package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Task {
    private ArrayList<Member> taskMembers;
    private Schedule schedule;
    private ArrayList<Risk> taskRisks;
    private double moneyBudget;
    private String description;
    private boolean isCompleted;

    public static final String noMembers = "";

    public Task(String description, int startWeek, int endWeek, double hourBudget, double moneyBudget){
        this.taskMembers = new ArrayList<>();
        this.taskRisks = new ArrayList<>();
        this.schedule = new Schedule(startWeek,endWeek,hourBudget);
        this.moneyBudget = moneyBudget;
        this.description = description;
        this.isCompleted = false;
    }

    public double getTotalCost(){
        double totalCost = 0.0;
        for(Member currentMember : taskMembers){
            totalCost += currentMember.getCostPerHour();
        }
        return totalCost;
    }

    public void addMember(Member memberToBeAdded){
        this.taskMembers.add(memberToBeAdded);
    }

    public void addRisk(String description, int probability, int impact){
        Risk newRisk = new Risk(description,probability,impact);
        taskRisks.add(newRisk);
    }

    public String getMembers(){
        if(taskRisks != null){
            String allMembers = noMembers;
            for (Member currentMember:taskMembers) {
                StringBuilder builder = new StringBuilder();
                builder.append(allMembers);
                allMembers += currentMember.getName();
            }
            return allMembers;
        }
        return noMembers;
    }

    public void setSchedule(int startWeek, int endWeek, int totalHoursBudget){
        this.schedule.setStartWeek(startWeek);
        this.schedule.setEndWeek(endWeek);
        this.schedule.setHourBudget(totalHoursBudget);
    }

    public void removeMember(Member memberToBeRemoved){
        for(Member currentMember : taskMembers){
            if(currentMember.getId() == memberToBeRemoved.getId()){
                taskMembers.remove(currentMember);
            }
        }
    }

    public int getWeeks(){
        return this.schedule.calculateWeeks();
    }
}
