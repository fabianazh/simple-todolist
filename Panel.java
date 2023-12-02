package ToDoList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel {
    private DefaultListModel<String> toDoListModel;
    private JList<String> toDoList;
    private JTextField taskField;
    private JButton addButton, removeButton;

    public Panel() {
        setBackground(Color.yellow);
        setLayout(new BorderLayout());

        toDoListModel = new DefaultListModel<>();

        toDoList = new JList<>(toDoListModel);
        toDoList.setFont(new Font("Roboto", Font.PLAIN, 16));

        toDoList.setCellRenderer(new NumberedListCellRenderer());

        JScrollPane listScrollPane = new JScrollPane(toDoList);
        add(listScrollPane, BorderLayout.CENTER);

        taskField = new JTextField();
        taskField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(taskField, BorderLayout.NORTH);

        createButtons();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    void createButtons() {
        addButton = new JButton("Tambah");
        addButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    toDoListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        removeButton = new JButton("Hapus");
        removeButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = toDoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    toDoListModel.remove(selectedIndex);
                }
            }
        });
    }

    private class NumberedListCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setText((index + 1) + ". " + value.toString());
            return label;
        }
    }
}
