import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ThirdExercise implements ActionListener {

    Frame frame;
    MenuBar menuBar;
    Menu menu1, menu2;
    MenuItem mitem1, mitem2, mitem3, mitem4, mitem5;
    FileDialog fileDialog;
    Label label;

    public ThirdExercise() {
        frame = new Frame("JDialog");
        menuBar = new MenuBar();

        menu1 = new Menu("File");
        mitem1 = new MenuItem("New");
        mitem2 = new MenuItem("Open");
        mitem3 = new MenuItem("Save");
        mitem4 = new MenuItem("Exit");

        menu1.add(mitem1);
        menu1.add(mitem2);
        menu1.add(mitem3);
        menu1.add(mitem4);

        menu2 = new Menu("Save-as");
        mitem5 = new MenuItem("jpeg");

        menu2.add(mitem5);
        menu1.add(menu2);

        menuBar.add(menu1);
        mitem2.addActionListener(this);
        mitem4.addActionListener(this);

        label = new Label("", Label.CENTER);
        frame.setMenuBar(menuBar);
        frame.add(label, BorderLayout.CENTER);
        frame.setSize(370, 270);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Open")) {
            fileDialog = new FileDialog(frame, "Open a file", FileDialog.LOAD);
            fileDialog.setVisible(true);
            String file = fileDialog.getDirectory() + fileDialog.getFile();
            label.setText("File to Open: " + file);
        } else if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ThirdExercise();
    }
}
