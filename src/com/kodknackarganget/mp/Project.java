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
        this.schedule = new Schedule(startWeek,endWeek);
        this.hourBudget = hourBudget;
        this.moneyBudget = moneyBudget;
        this.takenIDs = new ArrayList<>();

    }

    public Project saveAndLoadProject(Project project){
        return project;
    }

    public double calculateCostVariance() {
        return moneyBudget - getTotalCost();
    }

    public double calculateEarnedValue()throws Exception {
        if(!tasks.isEmpty()){
            double earnedValue = (getCompletedTasks().size() / getTasks().size()) * moneyBudget;
            return earnedValue;
        }else{
            throw new Exception("No tasks added");
        }
    }

    public double calculateScheduleVariance()throws Exception {

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

            totalCost += currentMember.getCostPerHour() * currentMember.getHoursWorked();
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

    public ArrayList<Task> getCompletedTasks()throws Exception {

        ArrayList<Task> completedTasks = new ArrayList<>();

        for (Task completedTask : tasks) {
            if(completedTask.isCompleted()) {

                completedTasks.add(completedTask);
            }
        }
        if(completedTasks.isEmpty()){
            throw new Exception("No tasks completed yet");
        }
        return completedTasks;
    }

    public ArrayList<Task> getCurrentTasks()throws Exception {

        ArrayList<Task> currentTasks = new ArrayList<>();

        for (Task currentTask : tasks){
            if (!currentTask.isCompleted()){
                currentTasks.add(currentTask);
            }
        }
        if(currentTasks.isEmpty()){
            throw new Exception("No current tasks");
        }
        return currentTasks;
    }

    public Member getMember(int id) throws Exception{

        for(Member desiredMember : projectMembers) {

            if(desiredMember.getId() == id) {

                return desiredMember;
            }
        }
        throw new Exception("Member not found");
    }

    public Member getMember(String name)throws Exception {

        for(Member desiredMember : projectMembers) {

            if(desiredMember.getName().equalsIgnoreCase(name)) {

                return desiredMember;
            }
        }
        throw new Exception("Member not found");
    }


    public Task getTask(String description)throws Exception {

        for(Task desiredTask : tasks) {

            if(desiredTask.getDescription().equalsIgnoreCase(description)) {

                return desiredTask;
            }
        }
        throw new Exception("Task not found");
    }


    public int getAmountOfWeeks() {

        return schedule.calculateWeeks();
    }

    public void addMember(String name, int id, String email, double costPerHour)throws Exception {
        for(Member currentMember : projectMembers){
            if(currentMember.getId() == id){
                throw new Exception("There is already a member with this ID");
            }
        }
        Member newMember = new Member (name, id, email, costPerHour);
        this.projectMembers.add(newMember);
    }

    public void addMemberToTask(int id, String description)throws Exception {

        Task desiredTask = getTask(description);
        Member memberToAdd = getMember(id);
        desiredTask.addMember(memberToAdd);
        memberToAdd.addTask(desiredTask.getDescription());
    }

    public void addTask(String description, int startWeek, int endWeek) {
        Task newTask = new Task(description,startWeek,endWeek);
        tasks.add(newTask);
    }

    public void addRisk(String description, int impact, int probability) {
        Risk newRisk = new Risk(description,impact,probability);
        projectRisks.add(newRisk);
    }

    public void addHoursToMember(Member member, double hours){
        member.addHoursWorked(hours);
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setStartWeek(int startWeek) {
        this.schedule.setStartWeek(startWeek);
    }

    public void setEndWeek(int endWeek){
        this.schedule.setEndWeek(endWeek);
    }

    public int getStartWeek(){
        return this.schedule.getStartWeek();
    }

    public int getEndWeek(){
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

