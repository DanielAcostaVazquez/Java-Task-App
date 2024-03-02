package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewContactGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel newContactLabel, nameLabel, emailLabel;
    private static JTextField emailText, nameText;
    private static JButton addButton, cancelButton;
    private Contact contactObject = new Contact();


    public NewContactGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: New Contact");
        frame.add(panel);

        panel.setLayout(null);

        newContactLabel = new JLabel("New Contact");
        newContactLabel.setBounds(5,5,300,50);
        newContactLabel.setFont(newContactLabel.getFont().deriveFont(30.0f));
        panel.add(newContactLabel);

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

        addButton = new JButton("Add");
        addButton.setBounds(600,150,100,50);
        addButton.addActionListener(this);
        panel.add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(680,405,100,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addButton){
            contactObject.add(nameText.getText(), emailText.getText());
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
