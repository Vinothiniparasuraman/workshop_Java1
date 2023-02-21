package com.provility.workshop.mortgage;


public class mortageRecords {
    String name;
    int principle;
    float annualInterest;
    int period;

    public mortageRecords(String name,int principle,float annualInterest,int period) {
        this.name = name;
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.period = period;
    }
    public String toString() {
        return "Name=" + name + ", Principle=" + principle + ", AnnualInterest=" + annualInterest +
                ",Period(Years)=" + period ;
    }

}

