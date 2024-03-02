package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEmailGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel emailLabel, passwordLabel;
    private static JTextField emailText;
    private static JPasswordField passwordText;
    private static JButton changeButton, cancelButton;
    Settings settingsObject = new Settings();

    public ChangeEmailGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Change Email");
        frame.add(panel);

        panel.setLayout(null);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(5,5,150,50);
        emailLabel.setFont(emailLabel.getFont().deriveFont(15.0f));
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(5,60,300,25);
        panel.add(emailText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(5,100,150,50);
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(15.0f));
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(5,165,300,25);
        panel.add(passwordText);

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
            new SettingsGUI();
            frame.dispose();
        }
        else if (e.getSource()== changeButton){
            settingsObject.setMyEmail(emailText.getText());
            settingsObject.setPassword(passwordText.getText());
            settingsObject.save();
            new SettingsGUI();
            frame.dispose();

        }

    }
}
