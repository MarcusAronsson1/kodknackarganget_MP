package com.kodknackarganget.mp;

import java.util.ArrayList;
import java.util.HashMap;

public class Member {
   private String name;
   private int id;
   private String email;
   private double costPerHour;
   private ArrayList<String> taskNames;
   private HashMap<String, Double> hoursWorked;

    public Member(String name, int id, String email, double costPerHour){
        this.name = name;
        this.id = id;
        this.email = email;
        this.costPerHour = costPerHour;
        this.hoursWorked = new HashMap<>();
        this.taskNames = new ArrayList<>();
    }

    public void addTask(String description){
        //Should forward something from Task, I would assume :)
    }

    public void addHoursWorked(String description, double hours) throws Exception{ // addHoursWorked on a specific task for a member
            if ((hoursWorked.containsKey(description))){
               hoursWorked.put(description,hours); // not sure if this is correct (Right now it just replaces the old hours and description)
            }else{
             Exception wrongKey = new Exception("The task does not exist, try again");
                  throw wrongKey;         // Add an error, since the description is not matched to an task
            }

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

    public HashMap<String, Double> getHoursWorked() {
        return hoursWorked;
    }
    public double getHoursWorked2(){
        return hoursWorked.get();
    }

}
