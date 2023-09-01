import app.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private JFrame frame;
    private List<Task> tasks;

    public Main() {
        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        tasks = new ArrayList<>();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea taskList = new JTextArea();
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = JOptionPane.showInputDialog(frame, "Enter task name:");
                if (taskName != null && !taskName.isEmpty()) {
                    String taskDescription = JOptionPane.showInputDialog(frame, "Enter task description:");
                    Task newTask = new Task(taskName, taskDescription);
                    tasks.add(newTask);
                    updateTaskList(taskList);
                }
            }
        });
        panel.add(addButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateTaskList(JTextArea taskList) {
        taskList.setText("");
        for (Task task : tasks) {
            taskList.append("Name: " + task.getName() + "\n");
            taskList.append("Description: " + task.getDescription() + "\n\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
