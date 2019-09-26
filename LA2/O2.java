/**
 * This class is for drawing an "O" for LA2.
 *@author James Dansie
 *@version LA2 - Graphics Check level
 */
public class O2 extends javax.swing.JComponent {
    /**
     * This field is the line color.
     */
    private java.awt.Color lc;
    
    /**
     *This field is the fill color
     */
    private java.awt.Color fc;
  
    /**
     * Constructor, sets the preferred size. Default line color is black.
     * The default fill color is white.
     */
    public O2() {
        setPreferredSize(new java.awt.Dimension(25, 25));
        setLineColor(java.awt.Color.BLACK);
        setFillColor(java.awt.Color.white);
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
     *@param rgb This is the color input.
     */
    public void setLineColor(java.awt.Color rgb){
        lc = rgb;
        repaint();
    }
    
    /**
     * This getter is for the fill color
     *@return Returns the fill color
     */
    public java.awt.Color getFillColor(){
        return fc;
    }
    
    /**
     * This setter is for the fill color. Repaints afterward.
     *@param rgb This is the color input.
     */
    public void setFillColor(java.awt.Color rgb){
        fc = rgb;
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
        // sets the color, then draws/fills the ojbect.
        g.setColor(lc);
        g.drawOval(0, 0, width-1, height-1);
        g.setColor(fc);
        g.fillOval(0, 0, width-1, height-1);    
    }
}
