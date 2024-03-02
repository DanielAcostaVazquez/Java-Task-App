package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI implements ActionListener {

    public static JFrame frame;
    public static JPanel panel;
    public static JLabel emailLabel, passwordLabel;
    public static JButton changeButton, changeMessageButton, cancelButton;
    public static Settings settingsObject = new Settings();

    public SettingsGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Settings");
        frame.add(panel);

        panel.setLayout(null);

        emailLabel = new JLabel("Your email: " + settingsObject.getMyEmail());
        emailLabel.setBounds(5,5,300,50);
        emailLabel.setFont(emailLabel.getFont().deriveFont(15.0f));
        panel.add(emailLabel);

        passwordLabel = new JLabel("Email's password: " + settingsObject.getPassword());
        passwordLabel.setBounds(5,75,300,50);
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(15.0f));
        panel.add(passwordLabel);

        changeButton = new JButton("Change");
        changeButton.setBounds(5,145,150,50);
        changeButton.addActionListener(this);
        panel.add(changeButton);

        changeMessageButton = new JButton("Change email message");
        changeMessageButton.setBounds(5,200,200,50);
        changeMessageButton.addActionListener(this);
        panel.add(changeMessageButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(680,405,100,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==cancelButton){
            new MainGUI();
            frame.dispose();
        }
        else if(e.getSource()==changeButton){
            new ChangeEmailGUI();
            frame.dispose();
        }
        else if(e.getSource()==changeMessageButton){
            new ChangeMessageGUI();
            frame.dispose();
        }

    }
}
