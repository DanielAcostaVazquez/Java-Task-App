package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Settings {

    private static String myEmail, password, mailMessage;
    private static Task taskObject = new Task();

      public Settings(){

      }

    public String getMyEmail() {
        return myEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getMailMessage() {
        return mailMessage;
    }

    public void setMyEmail(String myEmail) {
        Settings.myEmail = myEmail;
    }

    public void setPassword(String password) {
        Settings.password = password;
    }

    public void setMailMessage(String mailMessage) {
        Settings.mailMessage = mailMessage;
    }

    public void save(){
          try{
              RandomAccessFile file = new RandomAccessFile("settings.txt","rw");
              file.setLength(0);
              file.writeBytes(myEmail + "|" + password + "%" + mailMessage);
          }
          catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          catch (IOException e) {
              e.printStackTrace();
          }

      }

    public void load(){
          try{
              RandomAccessFile file = new RandomAccessFile("settings.txt","r");
              if(file.length() != 0){
                  String line = file.readLine();
                  myEmail = line.substring(0, line.indexOf("|"));
                  password = line.substring(line.indexOf("|") + 1, line.indexOf("%"));
                  mailMessage = line.substring(line.indexOf("%") + 1);
              }
              else {
                  myEmail = "myemail@default.com";
                  password = "defaultPassword123";
                  mailMessage = "Hello, I just wanted to ask for some advancements on the task that I assigned you. Thank you!";
                  save();
              }
          }
          catch (FileNotFoundException e) {
              e.printStackTrace();
          }
          catch (IOException e) {
              e.printStackTrace();
          }
    }

    public void sendMessage(String mailReciever, String taskName){

        String mailTo = mailReciever;
        String mailFrom = myEmail;
        String mailPassword = password;
        String hostMail = "smtp.gmail.com";

        Properties systemProperties = System.getProperties();
        systemProperties.setProperty("mail.smtp.host", hostMail);
        systemProperties.setProperty("mail.smtp.auth", "true");
        systemProperties.setProperty("mail.smtp.port","587");
        systemProperties.setProperty("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(systemProperties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(mailFrom,password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setSubject("Advancements on " + taskName + " task!");
            message.setText(this.getMailMessage());

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public void sendMessage(String mailReciever, String taskName, String mailContent){

        String mailTo = mailReciever;
        String mailFrom = myEmail;
        String mailPassword = password;
        String hostMail = "smtp.gmail.com";

        Properties systemProperties = System.getProperties();
        systemProperties.setProperty("mail.smtp.host", hostMail);
        systemProperties.setProperty("mail.smtp.auth", "true");
        systemProperties.setProperty("mail.smtp.port","587");
        systemProperties.setProperty("mail.smtp.starttls.enable","true");
        Session session = Session.getDefaultInstance(systemProperties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(mailFrom,password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setSubject("Advancements on " + taskName + " task!");
            message.setText(mailContent);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
