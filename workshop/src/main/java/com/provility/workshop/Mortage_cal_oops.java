package com.provility.workshop;

import java.util.Scanner;

public class Mortage_cal_oops {
    public float calculateMonthly(String prompt1, int min, int max){
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
    public static void main(String arg[]){
        Mortage_cal_oops obj = new Mortage_cal_oops();
        int principal =  (int)obj.calculateMonthly("Enter the principal",1000,1000000);
        float interest = (float) obj.calculateMonthly("Annual interest rate",0,30);
        int years = (int)obj.calculateMonthly("period(Years)",1,30);

        calculateMonthyMortagevalue(principal,interest,years);

    }
    private static void calculateMonthyMortagevalue(int principal,float interest,int years){

        double rateCal = 1 + interest;
        double power = Math.pow(rateCal, years);
        double numerator = (interest * power);
        double denominator = power - 1;
        double total = numerator / denominator;
        double monthly = principal * total;

        System.out.println("Mortgage  : $ " + monthly);

    }
}
