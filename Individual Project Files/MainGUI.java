package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class MainGUI implements ActionListener {

        private static JFrame frame;
        private static JPanel panel;
        private static JButton newTaskButton, contactsButton, settingsButton;
        private Contact contactObject = new Contact();
        private Task taskObject = new Task();
        private static Settings settingsObject = new Settings();
        int taskID;
        String taskClickedName, taskClickedContact, taskClickedDueDate, taskClickedEmail;
        JButton[] taskButtonArray;
        JLabel[] taskLabelArray;

    public MainGUI () {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Computer Science IA");
        frame.add(panel);

        panel.setLayout(null);

        newTaskButton = new JButton("+ Task");
        newTaskButton.setBounds(5,5,150,50);
        newTaskButton.addActionListener(this);
        panel.add(newTaskButton);

        contactsButton = new JButton("Contacts");
        contactsButton.setBounds(630,5,150,50);
        contactsButton.addActionListener(this);
        panel.add(contactsButton);

        settingsButton = new JButton("Settings");
        settingsButton.setBounds(680,405,100,50);
        settingsButton.addActionListener(this);
        panel.add(settingsButton);


        taskButtonArray = new JButton[10];
        taskLabelArray = new JLabel[10];

        for(int i = 0; i < taskObject.getTaskList().size(); i++){
            taskButtonArray[i] = new JButton(taskObject.getTaskList().get(i).name);
            taskButtonArray[i].setBounds(5,65+(35*i),500,25);
            taskButtonArray[i].addActionListener(this);

            taskLabelArray[i] = new JLabel("Due: " + taskObject.getDueDate(taskObject.getTaskList().get(i).day,taskObject.getTaskList().get(i).month, taskObject.getTaskList().get(i).year));
            taskLabelArray[i].setBounds(535,65+(35*i),100,25);

            if(checkDueTask(i)){
                taskLabelArray[i].setForeground(Color.RED);
            }

            panel.add(taskButtonArray[i]);
            panel.add(taskLabelArray[i]);

        }

        frame.setVisible(true);

    }

    public  boolean checkDueTask(int i){
            if((taskObject.getTaskList().get(i).year<= LocalDate.now().getYear())&&(taskObject.getTaskList().get(i).month<=LocalDate.now().getMonthValue())&&
                    taskObject.getTaskList().get(i).day<=LocalDate.now().getDayOfMonth()){
                settingsObject.sendMessage(taskObject.getTaskList().get(i).assignedContact.email,
                        taskObject.getTaskList().get(i).name, "Hey! the deadline I assigned you is up! Please send me all your advancements now!");
                settingsObject.sendMessage(settingsObject.getMyEmail(),taskObject.getTaskList().get(i).name,
                        "The Deadline you assigned for this task is up! Ask for advancements if you havent received any!");
                return true;
            }
            else{
                return false;
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newTaskButton){
            new CreateTaskGUI();
            frame.dispose();
        }
        else if (e.getSource()==contactsButton){
            new ContactGUI();
            frame.dispose();
        }
        else if (e.getSource()==settingsButton){
            new SettingsGUI();
            frame.dispose();
        }
        else{

            for(int i = 0; i < contactObject.getContactList().size(); i++){
                if(taskButtonArray[i]==e.getSource()){
                    this.taskClickedName = taskObject.getTaskList().get(i).name;
                    this.taskClickedContact = taskObject.getTaskList().get(i).assignedContact.name;
                    this.taskClickedDueDate = taskObject.getDueDate(taskObject.getTaskList().get(i).day,taskObject.getTaskList().get(i).month, taskObject.getTaskList().get(i).year);
                    this.taskClickedEmail = taskObject.getTaskList().get(i).assignedContact.email;
                    this.taskID = i;
                }
            }

            new TaskInfoGUI(taskClickedName, taskClickedContact, taskClickedEmail, taskClickedDueDate, this.taskID);
            frame.dispose();
        }
    }
}
