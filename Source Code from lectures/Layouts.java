public class Layouts {

    public static void main(String[] args) {
    
        javax.swing.JFrame win = new javax.swing.JFrame("Layouts");
        win.setSize(300, 225);
        win.setLocation(25, 25);
        win.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JButton one = new javax.swing.JButton("Click me");
        javax.swing.JButton two = new javax.swing.JButton("Don't forget me");

        win.add(one);
        win.add(two);

        win.setVisible(true);

        javax.swing.JOptionPane.showMessageDialog(win, "Change to FlowLayout");
        win.setLayout(new java.awt.FlowLayout());
        win.validate();

        // When showMessageDialog has null as the first parameter, the dialog box displays 
        // centered in the screen. This is handy for this demo code so that the dialog box 
        // doesn't obscure the window. In the video, the value win was used to insure that
        // the message dialog would be visible in the video. Here, it would just be annoying, 
        // because you would need to move the message box to see how the buttons are arranged.
        javax.swing.JOptionPane.showMessageDialog(null, "Change to GridLayout(1, 2)");
        win.setLayout(new java.awt.GridLayout(1, 2));
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change to GridLayout(2, 1)");
        win.setLayout(new java.awt.GridLayout(2, 1));
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change back to BorderLayout");
        win.setLayout(new java.awt.BorderLayout());
        // the BorderLayout keeps track of NORTH, SOUTH, EAST, WEST, and CENTER
        // it needs to be the current layout manager to keep track, so we add again
        win.add(one);
        win.add(two, java.awt.BorderLayout.NORTH);
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change to BorderLayout.WEST");
        win.add(two, java.awt.BorderLayout.WEST);
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change to BorderLayout.SOUTH");
        win.add(one, java.awt.BorderLayout.SOUTH);
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change to BorderLayout.EAST");
        win.add(one, java.awt.BorderLayout.EAST);
        win.validate();

        javax.swing.JOptionPane.showMessageDialog(null, "Change to JPanel toolbar");
        javax.swing.JPanel tool = new javax.swing.JPanel();
        win.add(one);
        tool.add(two);
        tool.add(new javax.swing.JButton("a new button"));
        win.add(tool, java.awt.BorderLayout.SOUTH);
        win.validate();

    }

}