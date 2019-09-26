import java.awt.*;
import javax.swing.*;

public class graphics{
    public static void main(String[] args){
        JFrame win = new JFrame("test");
        win.setSize(400, 300);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        doodle d = new doodle();
        win.add(d, BorderLayout.CENTER);
        //uncomment below to add a bottom section
//          d = new doodle();
//          win.add(d, BorderLayout.SOUTH);
         win.setVisible(true);
    }
}