package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactInfoGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel contactNameLabel, contactEmailLabel;
    private static JButton changeButton, cancelButton;
    String contactName, contactEmail;
    int contactNo;



    public ContactInfoGUI(String name, String email, int index){

        contactName = name;
        contactEmail = email;
        contactNo = index;


        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Contact Info");
        frame.add(panel);

        panel.setLayout(null);

        contactNameLabel = new JLabel(contactName);
        contactNameLabel.setBounds(5,5,300,50);
        contactNameLabel.setFont(contactNameLabel.getFont().deriveFont(30.0f));
        panel.add(contactNameLabel);

        contactEmailLabel = new JLabel("email: " + contactEmail);
        contactEmailLabel.setBounds(5,100,600,50);
        contactEmailLabel.setFont(contactEmailLabel.getFont().deriveFont(25.0f));
        panel.add(contactEmailLabel);

        changeButton = new JButton("Change");
        changeButton.setBounds(5,200,250,50);
        changeButton.addActionListener(this);
        panel.add(changeButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260,200,150,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancelButton){
            new ContactGUI();
            frame.dispose();
        }
        else if (e.getSource()== changeButton){

            new ChangeContactGUI(contactNo);
            frame.dispose();

        }

    }
}
