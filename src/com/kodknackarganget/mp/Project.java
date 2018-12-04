package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Project {

    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<Member> projectMembers;
    private ArrayList<Risk> projectRisks;
    private Schedule schedule;
    private double projectBudget;




    public Project(String name, int startWeek, int endWeek, double hourBudget, double projectBudget) {

        this.name = name;
        this.tasks = new ArrayList<>();
        this.projectMembers = new ArrayList<Member>();
        this.projectRisks = new ArrayList<>();
        this. schedule = new Schedule(startWeek, endWeek, hourBudget);
        this.projectBudget = projectBudget;

    }



    public double calculateCostVariance() {

    }

    public double calculateEarnedValue() {

    }

    public double calculateScheduleVariance() {

    }

    public double getTotalHours() {

    }

    public double getTotalHoursPerMember() {

    }

    public Risk getRisks() {

    }

    public Member getMembers() {

    }

    public Task getTasks() {

    }

    public double getTotalCost() {

    }

    public String getCompletedTasks() {
        for (Task completedTask : tasks) {
            if (completedTask.isCompleted == true) {      // need a getter to the boolean in task
                return  completedTask.toString();
            }
        }
        return "No completed tasks";

    }

    public String getCurrentTasks() {
        for (Task currentTask : tasks){
            if (currentTask.isCompleted == false){   // need a getter to the boolean in Task
                return currentTask.toString();
            }
        }
        return "No current tasks";
    }

    public Member getMember(int id) {

    }

    public Member getMember(String name) {

    }

    public int getWeek() {

    }

    public void addMember(int id) {

    }

    public void addTask(String description, int startWeek, int endWeek, double hourBudget, double moneyBudget) {
        Task newTask = new Task(description,startWeek,endWeek,hourBudget,moneyBudget);
        tasks.add(newTask);
    }

    public void addRisk(String description, int impact, int probability) {
        Risk newRisk = new Risk(description,impact,probability);
        projectRisks.add(newRisk);
    }

    public void setSchedule(int startWeek, int endWeek, double hourBudget) {

    }












}

