package com.company;


public class Main {

    public static void main(String[] args) {

        Contact contactObject = new Contact();
        Task taskObject = new Task();
        Settings settingsObject = new Settings();

        contactObject.load();
        taskObject.load();
        settingsObject.load();

        new MainGUI();


    }
}
