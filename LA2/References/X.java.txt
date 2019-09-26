/**
 * A sample component class.
 */
public class X extends javax.swing.JComponent {
  
    /**
     * Constructor, sets the preferred size.
     */
    public X() {
        setPreferredSize(new java.awt.Dimension(25, 25));
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
        // draw two lines
        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
    }
}
