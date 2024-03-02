package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskInfoGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel taskNameLabel, assignedToLabel, dueLabel;
    private static JButton advancementsButton, cancelButton, deleteButton;
    private static Task taskObject = new Task();
    private static int id;
    private static String name, contact, due, mail;


    public TaskInfoGUI(String taskName, String taskContact, String contactEmail, String dueDate, int index) {

        id = index;
        name = taskName;
        contact = taskContact;
        due = dueDate;
        mail = contactEmail;

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Task Info");
        frame.add(panel);

        panel.setLayout(null);

        taskNameLabel = new JLabel(taskName);
        taskNameLabel.setBounds(5,5,300,50);
        taskNameLabel.setFont(taskNameLabel.getFont().deriveFont(30.0f));
        panel.add(taskNameLabel);

        assignedToLabel = new JLabel("Assigned to: " + taskContact);
        assignedToLabel.setBounds(5,70,300,25);
        assignedToLabel.setFont(assignedToLabel.getFont().deriveFont(15.0f));
        panel.add(assignedToLabel);

        dueLabel = new JLabel("Due: " + dueDate);
        dueLabel.setBounds(5,110,300,25);
        dueLabel.setFont(dueLabel.getFont().deriveFont(15.0f));
        panel.add(dueLabel);

        advancementsButton = new JButton("Ask for Advancements");
        advancementsButton.setBounds(5,200,250,50);
        advancementsButton.addActionListener(this);
        panel.add(advancementsButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260,200,150,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(420,200,150,50);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancelButton){
            new MainGUI();
            frame.dispose();
        }
        else if (e.getSource()==deleteButton){
            taskObject.delete(id);
            new MainGUI();
            frame.dispose();
        }
        else if (e.getSource()== advancementsButton){
            new AdvancementsGUI(name, contact, mail, due);
            frame.dispose();
        }

    }
}
