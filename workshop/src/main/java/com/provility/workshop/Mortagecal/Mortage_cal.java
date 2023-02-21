package com.provility.workshop.Mortagecal;

import java.util.Scanner;

public class Mortage_cal {

    int principal;
    float interest;
    int years;

    public Mortage_cal(int principal,float interest,int years){
        this.principal = principal;
        this.interest = interest;
        this.years = years;

    }
    public static float calculateMonthly(String prompt1, int min, int max){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(prompt1);
            float value = sc.nextFloat();
            if(value>min && value<max){
                return value;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }



    }
    public static void calculateMonthyMortagevalue(int principal,float interest,int years){

        double rateCal = 1 + interest;
        double power = Math.pow(rateCal, years);
        double numerator = (interest * power);
        double denominator = power - 1;
        double total = numerator / denominator;
        double monthly = principal * total;

        System.out.println("Mortgage  : $ " + monthly);
    }


}
