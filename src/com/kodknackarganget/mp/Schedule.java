package com.kodknackarganget.mp;

public class Schedule {

    public static int LESS_LESS_THAN_ONE_WEEK = 0;
    public static int ONE_WEEK = 1;


    private int startWeek;
    private int endWeek;



    public Schedule(int startWeek, int endWeek) {

        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public int calculateWeeks() {         //Calculating the duration of the project in weeks

        if(endWeek - startWeek == LESS_LESS_THAN_ONE_WEEK) {

            return ONE_WEEK;
        }

        return endWeek - startWeek;
    }


    
    //Getters and Setters
    public int getStartWeek(){
        return startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }
}
