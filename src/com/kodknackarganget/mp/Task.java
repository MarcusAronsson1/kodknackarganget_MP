package com.kodknackarganget.mp;

import java.util.ArrayList;

public class Task {
    private ArrayList<Member> taskMembers;
    private Schedule schedule;
    private String description;
    private boolean isCompleted;

    public Task(String description, int startWeek, int endWeek){
        this.taskMembers = new ArrayList<>();
        this.schedule = new Schedule(startWeek,endWeek);
        this.description = description;
        this.isCompleted = false;
    }

    public void addMember(Member memberToBeAdded){
        this.taskMembers.add(memberToBeAdded);
    }

    public void setSchedule(int startWeek, int endWeek){
        this.schedule.setStartWeek(startWeek);
        this.schedule.setEndWeek(endWeek);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public ArrayList<Member> getTaskMembers() {
        return taskMembers;
    }

    public void setTaskMembers(ArrayList<Member> taskMembers) {
        this.taskMembers = taskMembers;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
