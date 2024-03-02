package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactGUI implements ActionListener {

    public static JFrame frame;
    public static JPanel panel;
    public static JButton newContactButton, cancelButton;
    private Contact contactObject = new Contact();
    public String contactClickedName, contactClickedEmail;
    public int index;
    JButton[] contactButtonArray;

    public ContactGUI(){

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Computer Science IA: Contacts");
        frame.add(panel);

        panel.setLayout(null);

        newContactButton = new JButton("+ Contact");
        newContactButton.setBounds(5,5,150,50);
        newContactButton.addActionListener(this);
        panel.add(newContactButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(680,405,100,50);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        contactObject.print();

        contactButtonArray = new JButton[10];

        for(int i = 0; i < contactObject.getContactList().size(); i++){
            contactButtonArray[i] = new JButton(contactObject.getContactList().get(i).name);
            contactButtonArray[i].setBounds(5,65+(35*i),500,25);
            contactButtonArray[i].addActionListener(this);

            panel.add(contactButtonArray[i]);

        }

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==cancelButton){
            new MainGUI();
            frame.dispose();
        }
        else if (e.getSource()==newContactButton){
            new NewContactGUI();
            frame.dispose();
        }
        else {

            for(int i = 0; i < contactObject.getContactList().size(); i++){
                if(contactButtonArray[i]==e.getSource()){
                    this.contactClickedName = contactObject.getContactList().get(i).name;
                    this.contactClickedEmail = contactObject.getContactList().get(i).email;
                    this.index = i;
                }
            }

            new ContactInfoGUI(contactClickedName, contactClickedEmail,this.index);
            frame.dispose();
        }

    }
}
