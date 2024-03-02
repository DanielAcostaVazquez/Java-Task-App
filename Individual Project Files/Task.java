package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Task {
    String name;
    Contact assignedContact;
    Contact contactObject = new Contact();
    int day, month, year;
    public static ArrayList<Task> taskList = new ArrayList<Task>();

    public Task(String name, Contact assignedContact, int day, int month, int year) {
        this.name = name;
        this.assignedContact = assignedContact;
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public Task(){

    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public void add(String name, Contact contact, int day, int month, int year){

        this.taskList.add(new Task(name, contact, day, month, year));

    }

    public void delete(int index){

        this.taskList.remove(index);
        save();

    }

    public String getDueDate(int day, int month, int year){
        return (day + "/" + month + "/" + year);
    }

    public void print(){

        System.out.println(taskList.size());
        for(int i = 0; i < taskList.size(); i++){
            System.out.println(taskList.get(i).name + " " + taskList.get(i).assignedContact + " Due: " + getDueDate(taskList.get(i).day, taskList.get(i).month,taskList.get(i).year));
        }

    }

    public void save(){
        Task[] taskArray = new Task[taskList.size()];
        this.taskList.toArray(taskArray);
        String path = new String();
        for(int i = 0; i < taskArray.length; i++){

            switch(i){
                case 0:
                    path = "task.txt";
                    break;
                case 1:
                    path = "task1.txt";
                    break;
                case 2:
                    path = "task2.txt";
                    break;

                case 3:
                    path = "task3.txt";
                    break;

                case 4:
                    path = "task4.txt";
                    break;
                case 5:
                    path = "task5.txt";
                    break;

                case 6:
                    path = "task6.txt";
                    break;

                case 7:
                    path = "task7.txt";
                    break;

                case 8:
                    path = "task8.txt";
                    break;

                case 9:
                    path = "task9.txt";
                    break;
            }

            try {
                RandomAccessFile file = new RandomAccessFile(path, "rw");
                file.setLength(0);
                file.writeBytes(taskArray[i].name + "|" + taskArray[i].assignedContact.index + "%" + taskArray[i].day + "#" + taskArray[i].month + "$" + taskArray[i].year);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    public void load() {

        this.taskList.clear();
        String path = new String();
        for(int i = 0; i < 10; i++){
            switch(i){
                case 0:
                    path = "task.txt";
                    break;
                case 1:
                    path = "task1.txt";
                    break;
                case 2:
                    path = "task2.txt";
                    break;

                case 3:
                    path = "task3.txt";
                    break;

                case 4:
                    path = "task4.txt";
                    break;
                case 5:
                    path = "task5.txt";
                    break;

                case 6:
                    path = "task6.txt";
                    break;

                case 7:
                    path = "task7.txt";
                    break;

                case 8:
                    path = "task8.txt";
                    break;

                case 9:
                    path = "task9.txt";
                    break;
            }
            try{
                RandomAccessFile file = new RandomAccessFile(path, "r");
                if(file.length() != 0) {
                    String line = file.readLine();
                    String temporalName = line.substring(0, line.indexOf("|"));
                    int temporalIndex = Integer.parseInt(line.substring(line.indexOf("|") + 1,line.indexOf("%")));
                    int temporalDay = Integer.parseInt(line.substring(line.indexOf("%")+1, line.indexOf("#")));
                    int temporalMonth = Integer.parseInt(line.substring(line.indexOf("#")+1,line.indexOf("$")));
                    int temporalYear = Integer.parseInt(line.substring(line.indexOf("$")+1));

                    add(temporalName, contactObject.contactList.get(temporalIndex), temporalDay, temporalMonth, temporalYear);
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
