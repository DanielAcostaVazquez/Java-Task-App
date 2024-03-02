package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeContactGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel changeContactLabel, nameLabel, emailLabel;
    private static JTextField emailText, nameText;
    private static JButton changeButton, cancelButton;
    public Contact contactObject = new Contact();
    int index;


    public ChangeContactGUI(int contactNo){

        index = contactNo;

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Edit Contact");
        frame.add(panel);

        panel.setLayout(null);

        changeContactLabel = new JLabel("Edit Contact");
        changeContactLabel.setBounds(5,5,300,50);
        changeContactLabel.setFont(changeContactLabel.getFont().deriveFont(30.0f));
        panel.add(changeContactLabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(5,70,150,25);
        nameLabel.setFont(nameLabel.getFont().deriveFont(15.0f));
        panel.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(5,110,300,25);
        panel.add(nameText);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(5,160,150,25);
        emailLabel.setFont(emailLabel.getFont().deriveFont(15.0f));
        panel.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(5,200,300,25);
        panel.add(emailText);

        changeButton = new JButton("Change");
        changeButton.setBounds(600,150,100,50);
        changeButton.addActionListener(this);
        panel.add(changeButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(680,405,100,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==changeButton){
            contactObject.getContactList().set(index, new Contact(nameText.getText(), emailText.getText()));
            contactObject.save();
            new ContactGUI();
            frame.dispose();
        }
        else if (e.getSource()==cancelButton){
            new ContactGUI();
            frame.dispose();
        }

    }

}
