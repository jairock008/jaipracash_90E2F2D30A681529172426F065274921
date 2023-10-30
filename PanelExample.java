import java.awt.*;
import java.awt.event.*;

class PanelExample extends Frame {

    public PanelExample() {
        setLayout(new GridLayout(2, 2, 10, 10));
        Panel panel1 = new Panel();
        Button bt1 = new Button("1");
        Button bt2 = new Button("2");
        Button bt3 = new Button("3");
        Button bt4 = new Button("4");
        Button bt5 = new Button("5");
        panel1.setLayout(new BorderLayout());
        panel1.add(bt1, BorderLayout.NORTH);
        panel1.add(bt2, BorderLayout.SOUTH);
        panel1.add(bt3, BorderLayout.EAST);
        panel1.add(bt4, BorderLayout.WEST);
        panel1.add(bt5, BorderLayout.CENTER);
        panel1.setBackground(Color.GRAY);
        add(panel1);

        Panel panel2 = new Panel();
        panel2.setLayout(new FlowLayout());
        Button bt6 = new Button("6");
        Button bt7 = new Button("7");
        Button bt8 = new Button("8");
        panel2.add(bt6);
        panel2.add(bt7);
        panel2.add(bt8);
        panel2.setBackground(Color.CYAN);
        add(panel2);

        Panel panel3 = new Panel();
        panel3.setBackground(Color.GREEN);
        add(panel3);

        Panel panel4 = new Panel();
        panel4.setBackground(Color.RED);
        add(panel4);
    }

    public static void main(String[] args) {
        PanelExample frame = new PanelExample();
        frame.setTitle("B.Sc. Computer Science");
        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
