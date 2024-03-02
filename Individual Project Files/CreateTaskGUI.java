package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

public class CreateTaskGUI implements ActionListener, ItemListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel taskNameLabel, dueDateLabel, assignToLabel, dayLabel, monthLabel, yearLabel, errorLabel;
    private static JTextField taskNameText,dayText, monthText, yearText;
    private static JButton assignButton, cancelButton;
    private JComboBox assignText;
    Contact contactObject = new Contact();
    Contact selectedContact = new Contact();
    Task taskObject = new Task();
    Settings settingsObject = new Settings();
    int day, month,year;


    public CreateTaskGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: New Task");
        frame.add(panel);

        panel.setLayout(null);

        taskNameLabel = new JLabel("Task Name:");
        taskNameLabel.setBounds(5,5,80,25);
        panel.add(taskNameLabel);

        taskNameText = new JTextField(20);
        taskNameText.setBounds(5,40,300,25);
        panel.add(taskNameText);

        assignToLabel = new JLabel("Assign To:");
        assignToLabel.setBounds(5,115,80,25);
        panel.add(assignToLabel);

        assignText = new JComboBox();
        assignText.setBounds(5,150,300,25);
        for(int i = 0; i < contactObject.getContactList().size(); i++){
            assignText.addItem(contactObject.getContactList().get(i).name);
        }
        assignText.addItemListener(this);
        panel.add(assignText);

        dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setBounds(660,5,80,25);
        panel.add(dueDateLabel);

        dayText = new JTextField();
        dayText.setBounds(660,40,25,25);
        panel.add(dayText);

        dayLabel = new JLabel("dd");
        dayLabel.setBounds(660,75,25,25);
        panel.add(dayLabel);

        monthText = new JTextField();
        monthText.setBounds(690,40,25,25);
        panel.add(monthText);

        monthLabel = new JLabel("mm");
        monthLabel.setBounds(690,75,25,25);
        panel.add(monthLabel);

        yearText = new JTextField();
        yearText.setBounds(720,40,35,25);
        panel.add(yearText);

        yearLabel = new JLabel("yyyy");
        yearLabel.setBounds(720,75,35,25);
        panel.add(yearLabel);

        assignButton = new JButton("Assign");
        assignButton.setBounds(500,270,150,50);
        assignButton.addActionListener(this);
        panel.add(assignButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(500,350,150,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        errorLabel = new JLabel("Please enter a valid Date");
        errorLabel.setBounds(480,150,180,50);
        errorLabel.setFont(errorLabel.getFont().deriveFont(15.0f));
        panel.add(errorLabel);
        errorLabel.setVisible(false);

        frame.setVisible(true);
    }

    public int setDayLimit(int month, int year){
        switch(month) {
            case 1:
                return 31;
            case 2:
                return (year%4==0) ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 31;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            new MainGUI();
            frame.dispose();
        }
        else if (e.getSource()== assignButton) {
            day = Integer.parseInt(dayText.getText());
            month = Integer.parseInt(monthText.getText());
            year = Integer.parseInt(yearText.getText());
                if ((month > 0 && month < 13) && (year >= LocalDate.now().getYear()) && (day > 0 && day <= setDayLimit(month, year))) {
                    if (year > LocalDate.now().getYear() || month > LocalDate.now().getMonthValue() || (month == LocalDate.now().getMonthValue() && day >= LocalDate.now().getDayOfMonth())) {
                        taskObject.add(taskNameText.getText(), selectedContact, day, month, year);
                        taskObject.print();
                        taskObject.save();
                        settingsObject.sendMessage(selectedContact.email, taskNameText.getText(), "Hey " + selectedContact.name + " I just assigned you a new task! For more info, contact me!");
                        new MainGUI();
                        frame.dispose();
                    } else {
                        errorLabel.setVisible(true);
                    }
                } else {
                    errorLabel.setVisible(true);
                }

        }

    }


    @Override
    public void itemStateChanged(ItemEvent e) {

        for(int i = 0; i < contactObject.getContactList().size(); i++){

            if(e.getItem().toString()== contactObject.getContactList().get(i).name&&e.getStateChange()==1){
                selectedContact = (new Contact(contactObject.getContactList().get(i).name,contactObject.getContactList().get(i).email,i));
                System.out.println(selectedContact.name + " " + selectedContact.email + " " + selectedContact.index);

            }

        }

    }
}
