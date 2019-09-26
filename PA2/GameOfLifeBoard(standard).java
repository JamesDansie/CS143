import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GameOfLifeBoard extends javax.swing.JPanel{
    
    private GameOfLife game;
    private javax.swing.JButton btn;
   
    public GameOfLifeBoard(GameOfLife game){
        this.game = game;
        setPreferredSize(new java.awt.Dimension(476, 476));
    }
   
    @Override
    public void paintComponent(java.awt.Graphics g) {
        g.setColor(java.awt.Color.black);
        for(int line = 0; line <= 19; line++){
            g.drawLine(0, line*25, 475, line*25);
            g.drawLine(line*25, 0, line*25, 475);
        }
        int state = 0;
        for(int row = 1; row <= 19; row++) {
			for(int col = 1; col <= 19; col++) {
				state = game.getCellState(row, col);
                if(state == 1)
					g.fillOval(col*25+5, row*25+5, 15, 15);
			}
		}

    }
    
    public static void main(String[] args){
        MyGameOfLife game = new MyGameOfLife();
        GameOfLifeBoard board = new GameOfLifeBoard(game);        
        
        JFrame win = new JFrame("Game Of Life");
        JPanel panel = new JPanel();
        JPanel buttonbar = new JPanel();
        
        JButton b1 = new JButton("Starting Point");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setBoard(game);
                win.repaint();
            }
        });

        JButton b2 = new JButton("Next Generation");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.nextGeneration();
                win.repaint();
            }
        });
        
        win.setSize(600, 600);
        win.setLocation(100,100);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonbar.add(b1);
        buttonbar.add(b2);
        panel.add(board);
        win.add(panel, BorderLayout.CENTER);
        win.add(buttonbar, BorderLayout.SOUTH);
        win.pack();
        win.setVisible(true);
    }
    
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