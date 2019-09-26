package csc143.gol;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 *This class takes a GameOfLife object and creates an interactive GUI.
 *@author James Dansie
 *@version PA7 - GameOfLife Standard
 */
public class GameOfLifeBoard extends javax.swing.JPanel
    implements java.util.Observer{
    /**
     *This field stores the game of life object.
     */
    private MyGameOfLife game;
    /**
     *This constructor sets the game, and sets the prefered size of the JPanel.
     *@param game This is the Game of life object.
     */
    public GameOfLifeBoard(MyGameOfLife game){
        this.game = game;
        //Use 476 so the outside boarder of the game (@475 pixeles) is included.
        setPreferredSize(new java.awt.Dimension(476, 476));
    }
    /**
     *This method overrides the JPanel to provide the graphics of the board.
     *@param g This is the graphics object for the JPanel.
     */
    @Override
    public void paintComponent(java.awt.Graphics g) {
        g.setColor(java.awt.Color.black);
        //This for loop draws the grid lines of the board. It draws a line
        //every 25 pixels.
        for(int line = 0; line <= 19; line++){
            g.drawLine(0, line*25, 475, line*25);
            g.drawLine(line*25, 0, line*25, 475);
        }
        //This loop goes through the game of life board and checks for live
        //cells. If it finds a live cell it draws a circle 15x15 pxls, and
        //offset 5 pixels from the grid line.
        int state = 0;
        for(int row = 1; row <= 19; row++) {
			for(int col = 1; col <= 19; col++) {
				state = game.getCellState(row, col);
                if(state == 1)
					g.fillOval((col-1)*25+5, (row-1)*25+5, 15, 15);
			}
		}
    }
    /**
     *This will recieve an update from the observable
     *@param o this is from the observable
     *@arg this is the arguement from the observable
     */
    @Override
    public void update(java.util.Observable o, Object arg){
        repaint();
    }
    
    /**
     *This is the main method of the application. It defines most of the
     *windows, buttons, and mice behavior.
     *@param args Input arguments are ignored.
     */
    public static void main(String[] args){
        //Initializing the game
        MyGameOfLife game = new MyGameOfLife();
        GameOfLifeBoard board = new GameOfLifeBoard(game);
        game.addObserver(board);        
        
        //Initializing the GUI
        JFrame win = new JFrame("Game Of Life");
        JPanel panel = new JPanel();
        JPanel buttonbar = new JPanel();
        
        /**
         *This button sets the starting point of the board.
         */
        JButton b1 = new JButton("Starting Point");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setBoard(game);
                win.repaint();
            }
        });
        /**
         *This button calls the next generation and repaints the window.
         */
        JButton b2 = new JButton("Next Generation");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.nextGeneration();
                win.repaint();
            }
        });
        
        /**
         *This button clears the board, and sets all cells to dead.
         */
        JButton b3 = new JButton("Clear Board");
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int row = 1; row <= 19; row++) {
        			for(int col = 1; col <= 19; col++) {
        				game.setCellState(row, col, GameOfLife.DEAD);
                        win.repaint();
        			}
        		}
            }
        });
        
        panel.addMouseListener(new MouseAdapter(){
            /**
             * When a mouse is clicked in the JPanel this adapter will get the
             * X and Y cooridinates (in pixels) and convert them to rows and
             * columns to match the game of life object. Then it will check
             * the state of the cell, and switch it from dead to alive or from
             * alive to dead.
             *@param e the mouse click event in the JPanel.
             */
            public void mouseClicked(MouseEvent e){
                //converting from pixels to rows & cols
                int x = e.getX()/25+1;
                int y = e.getY()/25+1;
//                 System.out.println("("+x+","+y+")"); //debugging code
//                 System.out.println(game.getCellState(y, x));
                //switching the cell toggle.
                if(game.getCellState(y, x) == GameOfLife.DEAD)
                    game.setCellState(y, x, GameOfLife.ALIVE);
                else if(game.getCellState(y, x) == GameOfLife.ALIVE)
                    game.setCellState(y, x, GameOfLife.DEAD);
                win.repaint();
            }
        });
        win.setSize(600, 600);
        win.setLocation(100,100);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonbar.add(b1);
        buttonbar.add(b2);
        buttonbar.add(b3);
        panel.add(board);
        win.add(panel, BorderLayout.CENTER);
        win.add(buttonbar, BorderLayout.SOUTH);
        win.pack();
        win.setVisible(true);
    }
    /**
     *This method sets the board according to the PA1 beginning condition.
     *Added a for loop to set all the cells back to dead first. This ensures
     *there are no ALIVE cells from the previous cases.
     *@param board This is the game of life object.
     */
    public static void setBoard(GameOfLife board) {
        for(int row = 1; row <= 19; row++) {
			for(int col = 1; col <= 19; col++) {
				board.setCellState(row, col, GameOfLife.DEAD);
			}
		}
        
        // the two alive cells in the upper left
        board.setCellState(3, 4, GameOfLife.ALIVE);
        board.setCellState(4, 4, GameOfLife.ALIVE);
        // the block in the upper right
        board.setCellState(3, 13, GameOfLife.ALIVE);
        board.setCellState(3, 14, GameOfLife.ALIVE);
        board.setCellState(4, 13, GameOfLife.ALIVE);
        board.setCellState(4, 14, GameOfLife.ALIVE);
        // the beehive in the center
        board.setCellState(8, 7, GameOfLife.ALIVE);
        board.setCellState(8, 8, GameOfLife.ALIVE);
        board.setCellState(9, 6, GameOfLife.ALIVE);
        board.setCellState(9, 9, GameOfLife.ALIVE);
        board.setCellState(10, 7, GameOfLife.ALIVE);
        board.setCellState(10, 8, GameOfLife.ALIVE);
        // the glider on the lower left
        board.setCellState(15, 6, GameOfLife.ALIVE);
        board.setCellState(16, 4, GameOfLife.ALIVE);
        board.setCellState(16, 6, GameOfLife.ALIVE);
        board.setCellState(17, 5, GameOfLife.ALIVE);
        board.setCellState(17, 6, GameOfLife.ALIVE);
        // the blinker in the lower right
        board.setCellState(13, 13, GameOfLife.ALIVE);
        board.setCellState(13, 14, GameOfLife.ALIVE);
        board.setCellState(13, 15, GameOfLife.ALIVE);
        
    }

}