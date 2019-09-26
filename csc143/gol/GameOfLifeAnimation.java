package csc143.gol;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *This class takes a GameOfLife object and creates an interactive GUI.
 *@author James Dansie
 *@version PA7 - GameOfLife Standard
 */
public class GameOfLifeAnimation{
    /**
     *This field stores the model
     */
    private MyGameOfLife model;
    /**
     *This field stores the view
     */
    private GameOfLifeBoard view;
    /**
     *This field stores the Generations per minute (GPM)
     */
    private int GPM;
    /**
     *This field stores if the game is in a running state
     */
    private boolean running;
    /**
     *This is the game of life animation constructor
     */
    public GameOfLifeAnimation(){
        model = new MyGameOfLife();
        view = new GameOfLifeBoard(model);
        model.addObserver(view);
        GPM = 120;
        running = false;
    }
    /**
     *This field is the name of the file to be loaded or saved
     */
    public String filename;
    /**
     *This method adds a pause for the thread
     *@param time this is how long the thread will wait in milliseconds
     */
    private void pause(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            System.out.println("something bad happened with pause");
        }
    }
    /**
     *This is the main method for the animation. It controls the 
     *buttons, mice, and windows.
     *@param args String arugments are ignored.
     */
    public static void main (String[] args){
        GameOfLifeAnimation animation = new GameOfLifeAnimation();
        
        //Initializing the GUI
        JFrame win = new JFrame("Animated GOL");
        JPanel topbar = new JPanel();
        JPanel spacer = new JPanel();
        spacer.add(animation.view);
        win.setSize(600, 600);
        win.setLocation(25,25);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel southContainer = new JPanel();
        JPanel bottombar = new JPanel();
        //Divides the south area into two labels
        //southContainer.setLayout(new java.awt.GridLayout(2, 1));
        southContainer.setLayout(new java.awt.GridLayout(1, 1));
        southContainer.add(topbar);
        //southContainer.add(bottombar);
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("File");
        
        //hanging window solution?
        win.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        JLabel GPMtext = new JLabel("Generations per minute:");
        //manual field for typing GPM
        JTextField GPMinput = new JTextField(""+animation.GPM);
        GPMinput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data = GPMinput.getText();
                try{
                    int intdata = java.lang.Integer.parseInt(data);
                    //checking if input is between 60 and 500
                    if(intdata >= 60 && intdata <= 500){
                        animation.GPM = intdata;
                    }else{
                        JOptionPane.showMessageDialog(win, "number between 60 and 500");
                    }
                //if it's not a number pop a warning
                }catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(win, "must be an int!");
                }
                //debugging code
                //System.out.println(data);
            }
        });
        
        /**
         *This button sets the starting point of the board.
         */
        JButton bstart = new JButton("Starting Point");
        bstart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Thread thread1 = new Thread(new Runnable(){
                    public void run(){
                        animation.view.setBoard(animation.model);
                        win.repaint();
                    }
                });
                thread1.start();
            }
        });
        
        /**
         *This button starts and stops the animations
         */
        JButton banimate = new JButton("Start Animation");
        banimate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Thread thread2 = new Thread(new Runnable(){
                    public void run(){
                        if(animation.running == true){
                            banimate.setText("Start Animation");
                            animation.running = false;
                        }else{
                            banimate.setText("Stop Animation");
                            animation.running = true;
                                while(animation.running){
                                animation.model.nextGeneration();
                                win.repaint();
                                animation.pause(1000/(animation.GPM/60));
                            }
                        }
                    }
                });
                thread2.start();
            }
        });
        
        /**
         *This button clears the board, and sets all cells to dead.
         */
        JButton bclear = new JButton("Clear Board");
        bclear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int row = 1; row <= 19; row++) {
        			for(int col = 1; col <= 19; col++) {
        				animation.model.setCellState(row, col, GameOfLife.DEAD);
                        win.repaint();
        			}
        		}
            }
        });
        /**
         *This button speeds up the animation by 20 GPM
         */
        JButton bplus = new JButton("+");
        bplus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if((animation.GPM += 20) >= 500){
                    animation.GPM = 500;
                    Toolkit.getDefaultToolkit().beep();
                }
                animation.GPM += 20;
            }
        });
        /**
         *This button slows down the animation by 20 GPM
         */
        JButton bminus = new JButton("-");
        bminus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if((animation.GPM -= 20) <= 60){
                    animation.GPM = 60;
                    Toolkit.getDefaultToolkit().beep();
                }
                animation.GPM -= 20;
            }
        });
        /**
         *This section is for reading the file name
         */
        JLabel filetext = new JLabel("Filename:");
        JTextField fileinput = new JTextField("");
        fileinput.setPreferredSize(new Dimension(100, 24));
        fileinput.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                //debugging code
                //System.out.println("what are you looking at?");
            }
            public void focusLost(FocusEvent e){
                animation.filename = fileinput.getText();
            }
        });
        
        /**
         *This button opens a file from the Filename input
         */
        JButton bopen = new JButton("Open");
        bopen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    //debugging code
                    //System.out.println(animation.filename);
                    animation.model.fileOpen(animation.filename);
                }catch(java.io.IOException f){
                    JOptionPane.showMessageDialog(win, "IO Error when opening "+animation.filename);
                }catch(ClassNotFoundException g){
                    JOptionPane.showMessageDialog(win, "Class Error when opening "+animation.filename);
                }
                win.repaint();
            }
        });
        /**
         *This button saves a file from the Filename input
         */
        JButton bsave = new JButton("Save");
        bsave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    //debugging code
                    //System.out.println(animation.filename);
                    animation.model.fileSave(animation.filename);
                }catch(java.io.IOException f){
                    JOptionPane.showMessageDialog(win, "Error saving "+animation.filename);
                }
            }
        });
        spacer.addMouseListener(new MouseAdapter(){
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
//                 System.out.println(animation.model.getCellState(y, x));
                //switching the cell toggle.
                if(animation.model.getCellState(y, x) == GameOfLife.DEAD)
                    animation.model.setCellState(y, x, GameOfLife.ALIVE);
                else if(animation.model.getCellState(y, x) == GameOfLife.ALIVE)
                    animation.model.setCellState(y, x, GameOfLife.DEAD);
                win.repaint();
            }
        });
        /**
         *This button is for the open in the menu bar
         */
        JMenuItem menuitem1 = new JMenuItem("Open");
        menuitem1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    JFileChooser fc = new JFileChooser();
    
                    fc.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Game of Life files (.gol)", "gol"));
                    fc.setAcceptAllFileFilterUsed(true);
                    fc.showOpenDialog(win);
                    java.io.File file = fc.getSelectedFile();
                    try{
                        animation.model.fileOpen(file);
                    }catch(java.io.IOException f){
                        JOptionPane.showMessageDialog(win, "IO error openning "+file.getName());
                    }catch(ClassNotFoundException f){
                        JOptionPane.showMessageDialog(win, "Class error openning "+file.getName());
                    }
                    win.repaint();
                }catch(NullPointerException g){
                }
            }
        });
        /**
         *This button is for the save in the menu bar
         */
        JMenuItem menuitem2 = new JMenuItem("Save");
        menuitem2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    JFileChooser fc = new JFileChooser();
                    fc.showSaveDialog(win);
                    java.io.File file = fc.getSelectedFile();
                    
                    if(file.exists()){
                        int confirmVal = JOptionPane.showConfirmDialog(win, 
                        "Overwrite file?", "Confirm File Overwrite", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(confirmVal == JOptionPane.YES_OPTION){
                            try{
                                animation.model.fileSave(file);
                            }catch(java.io.IOException f){
                                JOptionPane.showMessageDialog(win, "IO error saving "+file.getName());
                            }
                        }
                    }else{
                        try{
                            animation.model.fileSave(file);
                        }catch(java.io.IOException f){
                            JOptionPane.showMessageDialog(win, "IO error saving "+file.getName());
                        }
                    }
                }catch(NullPointerException g){
                
                }
            }
        });
        /**
         *This button is to clear the board
         */
        JMenuItem menuitem3 = new JMenuItem("Clear Board");
        menuitem3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int row = 1; row <= 19; row++) {
        			for(int col = 1; col <= 19; col++) {
        				animation.model.setCellState(row, col, GameOfLife.DEAD);
                        win.repaint();
        			}
        		}

            }
        });
        /**
         *This button is to exit the application
         */
        JMenuItem menuitem4 = new JMenuItem("Exit Game of Life");
        menuitem4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                win.setVisible(false);
                win.dispose();
            }
        });
        
        topbar.add(banimate);
        topbar.add(GPMtext);
        topbar.add(GPMinput);
        topbar.add(bplus);
        topbar.add(bminus);
        //topbar.add(bstart);
//         bottombar.add(filetext);
//         bottombar.add(fileinput);
//         bottombar.add(bopen);
//         bottombar.add(bsave);
//         bottombar.add(bclear);
        
        menu.add(menuitem1);
        menu.add(menuitem2);
        menu.addSeparator();
        menu.add(menuitem3);
        menu.add(menuitem4);
        menubar.add(menu);
        win.setJMenuBar(menubar);
        
        win.add(spacer, BorderLayout.CENTER);
        win.add(southContainer, BorderLayout.SOUTH);
        win.pack();   
        win.setVisible(true);
        
        //after everything is built, try starting with commandline arguments
        if(args.length > 0){
            try{
                animation.filename = args[0];
                //debugging code
                //System.out.println(animation.filename);
                animation.model.fileOpen(animation.filename);
            }catch(java.io.IOException f){
                JOptionPane.showMessageDialog(win, "IO Error when opening "+animation.filename);
            }catch(ClassNotFoundException g){
                JOptionPane.showMessageDialog(win, "Class Error when opening "+animation.filename);
            }
            win.repaint();
                
        }
    }
}