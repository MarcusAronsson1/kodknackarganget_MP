package com.kodknackarganget.mp;

import java.util.ArrayList;
import java.util.HashMap;

public class Member {
   private String name;
   private int id;
   private String email;
   private double costPerHour;
   private double hoursWorked;
   private ArrayList<String> taskNames;
   private final String END_OF_LINE = System.lineSeparator();

  // private HashMap<String, Double> hoursWorked;

    public Member(String name, int id, String email, double costPerHour){
        this.name = name;
        this.id = id;
        this.email = email;
        this.costPerHour = costPerHour;
        this.hoursWorked = 0;
        this.taskNames = new ArrayList<>();
    }

    public void addTask(String description){

    }

    public void addHoursWorked(double hours){ // addHoursWorked for a member
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
    public String toString() {
        String info = "Name: "+name+" Id:"+id + END_OF_LINE +
                "Email: "+email + END_OF_LINE+" Hours worked: "+hoursWorked;
        return info;
    }

}
