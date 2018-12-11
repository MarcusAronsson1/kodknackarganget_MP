package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Project {

    public static int INITIAL_HOURS = 0;
    public static double MINIMUM = 0.0;
    public static int RISK_NOT_FOUND = 0;
    public static final String ls = System.lineSeparator();

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
        this.schedule = new Schedule(startWeek, endWeek, hourBudget);
        this.projectBudget = projectBudget;

    }

    public double calculateCostVariance() {

        return projectBudget - getTotalCost();
    }

    public double calculateEarnedValue() {

    }
    public double calculateScheduleVariance() {

    }

    
    public double getTotalHours() {
        double totalHours = INITIAL_HOURS;

        for(Member currentMember : projectMembers) {

            totalHours += currentMember.getHoursWorked();
        }

        return totalHours;
    }

    public double getTotalCost() {

        double totalCost = MINIMUM;

        for(Member currentMember : projectMembers) {

            totalCost = currentMember.getCostPerHour() * currentMember.getHoursWorked();
        }

        return totalCost;
    }

    public ArrayList<Risk> getRisk() {
        return projectRisks;
    }

    public ArrayList<Member> getMembers() {
        return projectMembers;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public String getCompletedTasks() {
        for (Task completedTask : tasks) {
            if (completedTask.isCompleted == true) {      // need a getter to the boolean in task
                return  completedTask.toString();
            }
        }
        return "No completed tasks";
    }

    public String getCurrentTasks() {  //return arraylist
        for (Task currentTask : tasks){
            if (currentTask.isCompleted == false){   // need a getter to the boolean in Task
                return currentTask.toString();
            }
        }
        return "No current tasks";
    }

    public Member getMember(int id) {

        for(Member desiredMember : projectMembers) {

            if(desiredMember.getId() == id) {

                return desiredMember;
            }
        }
        return null;
    }

    public Member getMember(String name) {

        for(Member desiredMember : projectMembers) {

            if(desiredMember.getName().equals(name)) {

                return desiredMember;
            }
        }
        return null;
    }

    public int getAmountOfWeeks() {

        return schedule.calculateWeeks();
    }

    public void addMember(String name, int id, String email, double costPerHour) {

        Member newMember = new Member (name, id, email, costPerHour);
        this.projectMembers.add(newMember);

    }

    public void addMemberToTask(String name, String description) {

        
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

    public String getName() {
        return name;
    }

    public double getProjectBudget() {
        return projectBudget;
    }

    public void setName(String newName) {

    }

    public void setProjectBudget(double newProjectBudget) {

    }




}

