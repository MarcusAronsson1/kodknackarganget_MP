package com.kodknackarganget.mp;

public class Schedule {

    public static int LESS_LESS_THAN_ONE_WEEK = 0;
    public static int ONE_WEEK = 1;


    private int startWeek;
    private int endWeek;
    private double hourBudget;


    public Schedule(int startWeek, int endWeek, double hourBudget) {

        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.hourBudget = hourBudget;

    }

    public int calculateWeeks() {

        if(endWeek - startWeek == LESS_LESS_THAN_ONE_WEEK) {

            return ONE_WEEK;
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