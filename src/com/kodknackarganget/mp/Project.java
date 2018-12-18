package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Project {

    public static int INITIAL_HOURS = 0;
    public static double MINIMUM = 0.0;
    public static final String ls = System.lineSeparator();

    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<Member> projectMembers;
    private ArrayList<Risk> projectRisks;
    private Schedule schedule;
    private double hourBudget;
    private double moneyBudget;




    public Project(String name, int startWeek, int endWeek, double hourBudget, double moneyBudget) {

        this.name = name;
        this.tasks = new ArrayList<>();
        this.projectMembers = new ArrayList<Member>();
        this.projectRisks = new ArrayList<>();
        this.schedule = new Schedule(startWeek, endWeek, hourBudget);
        this.moneyBudget = moneyBudget;

    }

    public double calculateCostVariance() {

        return moneyBudget - getTotalCost();
    }

    public double calculateEarnedValue() {

        double earnedValue = (getCompletedTasks().size() / getTasks().size()) / moneyBudget;
        //double earnedValue = taskPercentageCompleted / projectBudget;

        return earnedValue;
    }

    public double calculateScheduleVariance() {

        return calculateEarnedValue() - (hourBudget - getTotalHours());
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

    public ArrayList<Risk> getRisks() {
        return projectRisks;
    }

    public ArrayList<Member> getProjectMembers() {
        return projectMembers;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Task> getCompletedTasks() {

        ArrayList<Task> completedTasks = new ArrayList<>();

        for (Task completedTask : tasks) {
            if(completedTask.isCompleted()) {

                completedTasks.add(completedTask);
            }
        }
        return completedTasks;
    }

    public ArrayList<Task> getCurrentTasks() {

        ArrayList<Task> currentTasks = new ArrayList<>();

        for (Task currentTask : tasks){
            if (!currentTask.isCompleted()){
                currentTasks.add(currentTask);
            }
        }
        return currentTasks;
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


    public Task getTask(String description) {

        for(Task desiredTask : tasks) {

            if(desiredTask.equals(description)) {

                return desiredTask;
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

        Task desiredTask = getTask(description);
        Member memberToAdd = getMember(name);

        desiredTask.addMember(memberToAdd);
    }

    public void addTask(String description, int startWeek, int endWeek) {
        Task newTask = new Task(description,startWeek,endWeek);
        tasks.add(newTask);
    }

    public void addRisk(String description, int impact, int probability) {
        Risk newRisk = new Risk(description,impact,probability);
        projectRisks.add(newRisk);
    }


    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(int startWeek, int endWeek) {

    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {

    }

    public double getProjectBudget() {
        return moneyBudget;
    }

    public void setProjectBudget(double newProjectBudget) {

    }

    public void setProjectMembers(ArrayList<Member> projectMembers) {
        this.projectMembers = projectMembers;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setProjectRisks(ArrayList<Risk> projectRisks) {
        this.projectRisks = projectRisks;
    }



}

