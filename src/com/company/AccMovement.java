package com.company;


public class AccMovement {
    private String date;
    private double value;
    private double taxValue;
    private char typeMovement;

    AccMovement(String date, double value, double taxValue, char typeMovement) {
        this.date = date;
        this.value = value;
        this.taxValue = taxValue;
        this.typeMovement = typeMovement;
    }

    public String getDate() {
        return this.date;
    }

    private double getValue() {
        return this.value;
    }

    private double getTax(){
        return this.taxValue;
    }

    private char getTypeMovement(){
        return this.typeMovement;
    }

}
