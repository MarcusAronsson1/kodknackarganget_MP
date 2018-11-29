package com.kodknackarganget.mp;

public class Schedule {

    private int startWeek;
    private int endWeek;
    private double hourBudget;


    public Schedule(int startWeek, int endWeek, double hourBudget) {

        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.hourBudget = hourBudget;

    }

    public int calculateWeeks() {

        if(endWeek - startWeek == 0) {

            return 1;
        }

        return endWeek - startWeek;
    }


    public int getStartWeek(){
        return startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public double getHourBudget() {
        return hourBudget;
    }

    public void setStartWeek(int newStartWeek) {

    }
    public void setEndWeek(int newEndWeek) {

    }
    public void setHourBudget(double newHourBudget) {

    }

    
}