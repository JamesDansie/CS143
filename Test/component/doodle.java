//This is the test case for drawing with components

public class doodle extends javax.swing.JComponent{
    
    public doodle(){
        setPreferredSize(new java.awt.Dimension(100, 50));
    }
    
    @Override
    public void paintComponent(java.awt.Graphics g) {

        int width = getWidth();
        int height = getHeight();
        //black Xs that move
        g.setColor(java.awt.Color.black);
        g.drawLine(0, 0, width/2, height);
        g.drawLine(0, height, width/2, 0);
        g.drawLine(width/2, 0, width, height);
        g.drawLine(width/2, height, width, 0);
        //blue Xs that are set
        g.setColor(java.awt.Color.blue);
        g.drawLine(0, 0, 50, 50);
        g.drawLine(0, 50, 50, 0);
        g.drawLine(50, 0, 100, 50);
        g.drawLine(50, 50, 100, 0);
    }
}