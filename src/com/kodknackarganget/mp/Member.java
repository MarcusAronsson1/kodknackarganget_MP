package com.kodknackarganget.mp;

import java.util.ArrayList;
import java.util.HashMap;

public class Member {
    String name;
    int id;
    String email;
    double costPerHour;
    ArrayList<String> taskNames;
    HashMap<String, Integer> hoursWorked;

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

    public void addHoursWorked(String description, double hours){
        hoursWorked // Add something to it i guess? not really sure
    }



}
