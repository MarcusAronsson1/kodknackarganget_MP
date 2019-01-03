package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Project {

    public static final int INITIAL_HOURS = 0;
    public static final double MINIMUM = 0.0;

    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<Member> projectMembers;
    private ArrayList<Risk> projectRisks;
    private ArrayList<Integer> takenIDs;
    private Schedule schedule;
    private double hourBudget;
    private double moneyBudget;


    public Project(String name, int startWeek, int endWeek, double hourBudget, double moneyBudget) {

        this.name = name;
        this.tasks = new ArrayList<>();
        this.projectMembers = new ArrayList<Member>();
        this.projectRisks = new ArrayList<>();
        this.schedule = new Schedule(startWeek, endWeek);
        this.hourBudget = hourBudget;
        this.moneyBudget = moneyBudget;
        this.takenIDs = new ArrayList<>();

    }

    public double calculateCostVariance() {
        return moneyBudget - getTotalCost();
    }


    public double calculateEarnedValue() throws Exception {
        if (!tasks.isEmpty()) {
            double earnedValue = ((double)getCompletedTasks().size() / (double)tasks.size()) * moneyBudget;
            return earnedValue;
        } else {
            throw new Exception("No tasks added");
        }
    }


    public double calculateScheduleVariance() throws Exception {
        return calculateEarnedValue() - moneyBudget;
    }


    public double getTotalHours() {         //Calculating the total hours spent on the project based on the amount of hours each member has worked
        double totalHours = INITIAL_HOURS;

        for (Member currentMember : projectMembers) {

            totalHours += currentMember.getHoursWorked();
        }
        return totalHours;
    }

    public double getTotalCost() {        //Calculating the total cost of the project based on each members cost per hour and the amount of hours they have worked

        double totalCost = MINIMUM;

        for (Member currentMember : projectMembers) {
            totalCost = totalCost + (currentMember.getCostPerHour() * currentMember.getHoursWorked());
        }

        return totalCost;
    }

    public ArrayList<Risk> getRisks() {       //Arraylist containing the risks of the project
        return projectRisks;
    }

    public ArrayList<Member> getProjectMembers() {      //Arraylist containing the members within the project
        return projectMembers;
    }

    public ArrayList<Task> getTasks() {         //Arraylist containing the tasks within the project
        return tasks;
    }


    public ArrayList<Task> getCompletedTasks(){

        ArrayList<Task> completedTasks = new ArrayList<>();

        for (Task currentTask : tasks) {
            if (currentTask.isCompleted()) {
                completedTasks.add(currentTask);
            }
        }
        return completedTasks;
    }

    public ArrayList<Task> getCurrentTasks()throws Exception {     //Arraylist containing the tasks which has yet to be completed within the project

        ArrayList<Task> currentTasks = new ArrayList<>();

        for (Task currentTask : tasks) {
            if (!currentTask.isCompleted()) {
                currentTasks.add(currentTask);
            }
        }
        if (currentTasks.isEmpty()) {
            throw new Exception("No current tasks");
        }
        return currentTasks;
    }

    public Member getMember(int id) throws Exception{      //Identifies a member based on their ID

        for (Member desiredMember : projectMembers) {

            if (desiredMember.getId() == id) {

                return desiredMember;
            }
        }
        throw new Exception("Member not found");
    }

    public Member getMember(String name)throws Exception {    //Identifies a member based on their name

        for (Member desiredMember : projectMembers) {

            if (desiredMember.getName().equalsIgnoreCase(name)) {

                return desiredMember;
            }
        }
        throw new Exception("Member not found");
    }


    public Task getTask(String description)throws Exception {     //Finds a task based on its description
        for (Task desiredTask : tasks) {

            if (desiredTask.getDescription().equalsIgnoreCase(description)) {

                return desiredTask;
            }
        }
        throw new Exception("Task not found");
    }


    public int getAmountOfWeeks() {      //Calculating the duration of the project in weeks

        return schedule.calculateWeeks();
    }

    public void addMember(String name, int id, String email, double costPerHour)throws Exception {    //Add member to project, makes sure that two members with the same ID can not be added
        for(Member currentMember : projectMembers){
            if(currentMember.getId() == id){
                throw new Exception("There is already a member with this ID");
            }
        }
        Member newMember = new Member(name, id, email, costPerHour);
        this.projectMembers.add(newMember);
    }

    public void addMemberToTask(int id, String description)throws Exception {    //Adding a member to a task and the task to the member

        Task desiredTask = getTask(description);
        Member memberToAdd = getMember(id);
        desiredTask.addMember(memberToAdd);
        memberToAdd.addTask(desiredTask.getDescription());
    }


    public void addTask(String description, int startWeek, int endWeek) {    //Adding a task to the project
        Task newTask = new Task(description,startWeek,endWeek);
        tasks.add(newTask);
    }

    public void addRisk(String description, int impact, int probability) {     //Adding a risk to the project
        Risk newRisk = new Risk(description,impact,probability);
        projectRisks.add(newRisk);
    }

    public void addHoursToMember(Member member, double hours){     //Adding hours to the total amount of hours worked by a member
        member.addHoursWorked(hours);
    }

    
    
    //Getters and Setters
    public Schedule getSchedule() {
        return schedule;
    }

    public void setStartWeek(int startWeek) {
        this.schedule.setStartWeek(startWeek);
    }

    public void setEndWeek(int endWeek) {
        this.schedule.setEndWeek(endWeek);
    }

    public int getStartWeek() {
        return this.schedule.getStartWeek();
    }

    public int getEndWeek() {
        return this.schedule.getEndWeek();
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getProjectBudget() {
        return moneyBudget;
    }

    public void setMoneyBudget(double newMoneyBudget) {
        this.moneyBudget = newMoneyBudget;
    }

    public double getMoneyBudget() {
        return moneyBudget;
    }

    public double getHourBudget() {
        return hourBudget;
    }

    public void setHourBudget(double hourBudget) {
        this.hourBudget = hourBudget;
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

