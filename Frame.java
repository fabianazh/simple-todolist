package ToDoList;

import java.awt.Color;
import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        setTitle("To Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        Panel panel = new Panel();
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
