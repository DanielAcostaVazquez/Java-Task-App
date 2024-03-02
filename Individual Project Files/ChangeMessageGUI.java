package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeMessageGUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel previousLabel, messageLabel, newLabel;
    private static JTextArea emailText;
    private static JButton changeButton, cancelButton;
    Settings settingsObject = new Settings();


    public ChangeMessageGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Change Email Message");
        frame.add(panel);

        panel.setLayout(null);

        previousLabel = new JLabel("Previous:");
        previousLabel.setBounds(5,5,300,50);
        previousLabel.setFont(previousLabel.getFont().deriveFont(25.0f));
        panel.add(previousLabel);

        messageLabel = new JLabel(settingsObject.getMailMessage() );
        messageLabel.setBounds(5,70,700,100);
        messageLabel.setFont(messageLabel.getFont().deriveFont(15.0f));
        panel.add(messageLabel);

        newLabel = new JLabel("New:");
        newLabel.setBounds(5,200,300,50);
        newLabel.setFont(newLabel.getFont().deriveFont(25.0f));
        panel.add(newLabel);

        emailText = new JTextArea();
        emailText.setBounds(5,260,600,200);
        emailText.setLineWrap(true);
        panel.add(emailText);

        changeButton = new JButton("Change");
        changeButton.setBounds(620,280,150,70);
        changeButton.addActionListener(this);
        panel.add(changeButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(620,370,150,70);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==changeButton){
            settingsObject.setMailMessage(emailText.getText());
            settingsObject.save();
            new SettingsGUI();
            frame.dispose();
        }
        else if (e.getSource()==cancelButton){
            new SettingsGUI();
            frame.dispose();
        }

    }
}
