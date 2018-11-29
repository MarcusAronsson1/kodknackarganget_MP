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



}