package com.kodknackarganget.mp;

public class Risk {
    private String description;
    private int probability;
    private int impact;

    public Risk(String description, int probability, int impact){
        this.description = description;
        this.probability = probability;
        this.impact = impact;
    }

    public int calculateRisk(){            //Calculating the risk of the project
        int risk;
        risk =this.probability * this.impact;
        return risk;
    }
    
    
    
    //Getters and Setters
    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

