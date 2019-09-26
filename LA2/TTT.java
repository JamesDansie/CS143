import java.awt.*;
import javax.swing.*;

/**
 * Tic Tac Toe code for LA2.
 *
 * @author James Dansie
 * @version LA2 - Graphics
 */
public class TTT {

  /**
   * This class creates the tic tac toe board.
   * @param args The command-line arguments, ignored
   */
  public static void main(String[] args) {

    // setup the window
    JFrame win = new JFrame("Test Component");
    win.setSize(400, 300);
    win.setLayout(new GridLayout(3, 3));
    win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // create the third component, O2 with custom color
    O2 o = new O2();
    o.setLineColor(Color.red);
    o.setFillColor(Color.yellow);
    win.add(o);

    // create the fourth component, X2 with custom color
    X2 x = new X2();
    x.setLineColor(Color.blue);
    win.add(x);
    
    win.paintComponent.drawLine(0,0,100,100);
    o = new O2();
    o.setLineColor(Color.red);
    o.setFillColor(Color.yellow);
    win.add(o);
    x = new X2();
    x.setLineColor(Color.blue);
    win.add(x);
        o = new O2();
    o.setLineColor(Color.red);
    o.setFillColor(Color.yellow);
    win.add(o);
    x = new X2();
    x.setLineColor(Color.blue);
    win.add(x);
        o = new O2();
    o.setLineColor(Color.red);
    o.setFillColor(Color.yellow);
    win.add(o);
    
    x = new X2();
    x.setLineColor(Color.blue);
    
    JPanel lilwin = new JPanel();
    lilwin.setSize(50, 50);
    lilwin.setLayout(new BorderLayout());
    lilwin.add(x, BorderLayout.CENTER);
    lilwin.add(o, BorderLayout.NORTH);
    lilwin.add(o, BorderLayout.SOUTH);
    lilwin.add(o, BorderLayout.EAST);
    lilwin.add(o, BorderLayout.WEST);
    win.add(lilwin);
        
    // show the window
    win.setVisible(true);

  }
}