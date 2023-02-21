package com.provility.workshop.Mortagecal;

public class main {

    public static void main(String arg[]){

        int principal =  (int)Mortage_cal.calculateMonthly("Enter the principal",1000,1000000);
        float interest = (float) Mortage_cal.calculateMonthly("Annual interest rate",0,30);
        int years = (int)Mortage_cal.calculateMonthly("period(Years)",1,30);

        Mortage_cal Mortage_cal = new Mortage_cal(principal,interest,years);

        Mortage_cal.calculateMonthyMortagevalue(principal,interest,years);

    }

}
