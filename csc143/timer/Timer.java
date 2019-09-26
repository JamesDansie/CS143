package csc143.timer;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *This class is the timer for LA 10
 *@author James Dansie
 *@version LA 10 - Timer Check Level
 */
public class Timer{
    /**
     *This field stores the run status
     */
    public boolean run;
    /**
     *This field stores the time value
     */
    public double time;
    /**
     *Parameterless constructor
     */
    public Timer(){
        run = false;
        time = 0;
    }
    /**
     *This method pauses the thread
     *@param time the time to pause the thread in milliseconds
     */
    public void pause(int time){
        try{
            //time is in milliseconds
            Thread.sleep(time);
        }catch(InterruptedException e){
            System.out.println("something bad happened with pause");
        }
    }
    /**
     *The main application call
     *@param args String input is ignored
     */
    public static void main(String[] args){
        Timer time = new Timer();
        JFrame win = new JFrame("My Timer");
        
        //the hanging window fix
        win.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        win.setSize(400, 300);
        win.setLocation(50, 50);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel buttonbar = new JPanel();
        JLabel timeLabel = new JLabel(String.format("%.2f", time.time));
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new GridBagLayout());
        timePanel.add(timeLabel);
        
        win.add(buttonbar, java.awt.BorderLayout.NORTH);
        win.add(timePanel, java.awt.BorderLayout.CENTER);
        
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Thread thread1 = new Thread(new Runnable(){
                    public void run(){
                        if(time.run == true){
                            btnStart.setText("Start");
                            time.run = false;
                        }else{
                            btnStart.setText("Stop");
                            time.run = true;
                            while(time.run == true){
                                time.pause(10);
                                time.time += 0.01;
                                timeLabel.setText(String.format("%.2f", time.time));
                            }
                        }
                    }
                });
                thread1.start();
            }
        });
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                time.run = false;
                time.time = 0;
                btnStart.setText("Start");
                timeLabel.setText(String.format("%.2f", time.time));
                win.repaint();
            }
        });
        
        buttonbar.add(btnStart);
        buttonbar.add(btnReset);
        
        win.setVisible(true);
    }
}