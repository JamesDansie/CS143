//test graphics zone
import java.awt.*;

public class DrawShapes2{
    public static void main(String[] agrs){
        DrawingPanel panel = new DrawingPanel(200, 100);
        
        Graphics g = panel.getGraphics();
        g.fillRect(25, 50, 20 , 20);
        g.drawRect(150, 10, 40, 20);
    }
}