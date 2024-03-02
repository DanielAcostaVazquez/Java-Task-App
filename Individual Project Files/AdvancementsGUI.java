package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancementsGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel askLabel, taskLabel, assignedToLabel, dueLabel;
    private static JButton sendButton, cancelButton;
    private static Settings settingsobject = new Settings();
    private static  String mailAdress, nameOfTask;

    public AdvancementsGUI(String taskName, String taskContact, String contactEmail, String dueDate){

        mailAdress = contactEmail;
        nameOfTask = taskName;

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Ask for Advancements");
        frame.add(panel);

        panel.setLayout(null);

        askLabel = new JLabel("Want to ask for advancements?");
        askLabel.setBounds(5,5,500,50);
        askLabel.setFont(askLabel.getFont().deriveFont(30.0f));
        panel.add(askLabel);

        taskLabel = new JLabel("Task: " + taskName);
        taskLabel.setBounds(5,70,300,25);
        taskLabel.setFont(taskLabel.getFont().deriveFont(15.0f));
        panel.add(taskLabel);

        assignedToLabel = new JLabel("To: " + taskContact);
        assignedToLabel.setBounds(5,110,300,25);
        assignedToLabel.setFont(assignedToLabel.getFont().deriveFont(15.0f));
        panel.add(assignedToLabel);

        dueLabel = new JLabel("Due: " + dueDate);
        dueLabel.setBounds(5,150,300,25);
        dueLabel.setFont(dueLabel.getFont().deriveFont(15.0f));
        panel.add(dueLabel);

        sendButton = new JButton("Send");
        sendButton.setBounds(5,200,150,50);
        sendButton.addActionListener(this);
        panel.add(sendButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260,200,150,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancelButton){
            new MainGUI();
            frame.dispose();
        }
        else if (e.getSource()== sendButton){
            settingsobject.sendMessage(mailAdress, nameOfTask);
            new MainGUI();
            frame.dispose();

        }

    }
}
