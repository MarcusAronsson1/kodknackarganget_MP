package com.kodknackarganget.mp;

import java.util.ArrayList;


public class Member {
   private String name;
   private int id;
   private String email;
   private double costPerHour;
   private double hoursWorked;
   private ArrayList<String> taskNames;  // UML says it is suppose to be a String and not a Task in itself
   private final String END_OF_LINE = System.lineSeparator();



    public Member(String name, int id, String email, double costPerHour){
        this.name = name;
        this.id = id;
        this.email = email;
        this.costPerHour = costPerHour;
        this.hoursWorked = 0;
        this.taskNames = new ArrayList<>();
    }

    public void addTask(String taskName){       // Have to add a String and not a task
        this.taskNames.add(taskName);
    }

    public void addHoursWorked(double hours){
        hoursWorked += hours;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public ArrayList<String> getTaskNames() {
        return taskNames;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
    @Override
    public String toString() {                  // Not really sure if we're going to need this since we have FX
        String info = "Name: "+name+" Id:"+id + END_OF_LINE +
                "Email: "+email + END_OF_LINE+" Hours worked: "+hoursWorked;
        return info;
    }

}
