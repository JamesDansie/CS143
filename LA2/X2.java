/**
 * This class is for drawing an "X" for LA2.
 *@author James Dansie
 *@version LA2 - Graphics Check level
 */
public class X2 extends javax.swing.JComponent {
    /**
     * This field is the line color.
     */
    private java.awt.Color lc;
  
    /**
     * Constructor, sets the preferred size. Default color is black.
     */
    public X2() {
        setPreferredSize(new java.awt.Dimension(25, 25));
        setLineColor(java.awt.Color.BLACK);
    }
    
    /**
     * Getter, gets the line color.
     *@return Returns the color.
     */
    public java.awt.Color getLineColor(){
        return lc;
    }
    
    /**
     * Setter, sets the line color, and repaints with the new color.
     *@param rgb This is the color input for a line.
     */
    public void setLineColor(java.awt.Color rgb){
        lc = rgb;
        repaint();
    }
    
    /**
     * The necessary method. This method renders the component.
     * 
     * @param g The Graphics object use to render
     */
    @Override
    public void paintComponent(java.awt.Graphics g) {
        // paint the underlying component
        super.paintComponent(g);
        // set the size
        int width = getWidth();
        int height = getHeight();
        // draw two lines and set the color
        g.setColor(lc);
        g.drawLine(0, 0, width-1, height-1);
        g.drawLine(0, height-1, width-1, 0);
    }
}
