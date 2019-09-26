public class ButtonHandler extends javax.swing.JFrame 
    implements java.awt.event.ActionListener {

    private javax.swing.JButton btn;

    public ButtonHandler() {
        super("Button Handler");
        setSize(400, 300);
        setLocation(50, 50);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btn = new javax.swing.JButton("Click me");
        add(btn);
        btn.addActionListener(this);
        btn.addActionListener(new Counter());
        setVisible(true);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        btn.setText("Thanks, I needed that");
    }

    public static void main(String[] args) {
        new ButtonHandler();
    }

}

class Counter implements java.awt.event.ActionListener {

    private int count;
    
    public Counter() {
        count = 0;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("Click number: " + ++count);
    }
}