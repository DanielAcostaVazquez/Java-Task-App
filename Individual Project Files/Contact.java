package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Contact   {
     public String name;
     public String email;
     int index;
     public static ArrayList<Contact> contactList = new ArrayList<Contact>();

    public Contact(String name, String email, int index) {
        this.name = name;
        this.email = email;
        this.index = index;
    }

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public Contact() {

    }

    public ArrayList<Contact> getContactList() {
        return this.contactList;
    }

    public void add(String name, String email){

        this.contactList.add(new Contact(name,email, contactList.size()));

    }

    public void print(){

        for(int i = 0; i < contactList.size(); i++){
            System.out.println(contactList.get(i).name + " " + contactList.get(i).email);
        }

    }

    public void save(){
        Contact[] contactArray = new Contact[getContactList().size()];
        this.contactList.toArray(contactArray);
        String path = new String();
        for(int i = 0; i < contactArray.length; i++){

            switch(i){
                case 0:
                    path = "contact.txt";
                    break;
                case 1:
                    path = "contact1.txt";
                    break;
                case 2:
                    path = "contact2.txt";
                    break;

                case 3:
                    path = "contact3.txt";
                    break;

                case 4:
                    path = "contact4.txt";
                    break;
                case 5:
                    path = "contact5.txt";
                    break;

                case 6:
                    path = "contact6.txt";
                    break;

                case 7:
                    path = "contact7.txt";
                    break;

                case 8:
                    path = "contact8.txt";
                    break;

                case 9:
                    path = "contact9.txt";
                    break;
            }

            try {
                RandomAccessFile file = new RandomAccessFile(path, "rw");
                file.setLength(0);
                file.writeBytes(contactArray[i].name + "|" + contactArray[i].email);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public void load() {

        this.contactList.clear();
        String path = new String();
        for(int i = 0; i < 10; i++){
            switch(i){
                case 0:
                    path = "contact.txt";
                    break;
                case 1:
                    path = "contact1.txt";
                    break;
                case 2:
                    path = "contact2.txt";
                    break;

                case 3:
                    path = "contact3.txt";
                    break;

                case 4:
                    path = "contact4.txt";
                    break;
                case 5:
                    path = "contact5.txt";
                    break;

                case 6:
                    path = "contact6.txt";
                    break;

                case 7:
                    path = "contact7.txt";
                    break;

                case 8:
                    path = "contact8.txt";
                    break;

                case 9:
                    path = "contact9.txt";
                    break;
            }
            try{
                RandomAccessFile file = new RandomAccessFile(path, "r");
                if(file.length() != 0) {
                    String line = file.readLine();
                    String temporalName = line.substring(0, line.indexOf("|"));
                    String temporalEmail = line.substring(line.indexOf("|") + 1);
                    add(temporalName, temporalEmail);
                    System.out.println("Load completed");
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }

}
