package com.provility.workshop;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortage_calc_func {

    static double enterPrompt(String prompt1, int min, int max ) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(prompt1);
            float value = sc.nextFloat();
            if (value > min && value <= max) {
                return value;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
    }


    public static void main(String[] args) {
        int principal = (int) enterPrompt("Enter Principal amount:", 1000, 100000);
        float rateOfInterest = (float) enterPrompt("Annual Interest Rate", 0, 30);
        byte noOfYears = (byte) enterPrompt("Period(Years):", 1, 30);

        calculateMonthlyMortgageValue(principal,rateOfInterest,noOfYears);

    }

    private static void calculateMonthlyMortgageValue(int principal, float rateOfInterest, byte noOfYears) {
        // mortgageCalculation formula used = p((r(1+n)^n)/(1+r)^n-1))
        double rateCal = 1 + rateOfInterest;
        double power = Math.pow(rateCal, noOfYears);
        double numerator = (rateOfInterest * power);
        double denominator = power - 1;
        double total = numerator / denominator;
        double monthlyMortgageValue = principal * total;
        String formattedValue = NumberFormat.getCurrencyInstance().format(monthlyMortgageValue);

        System.out.println("Monthly Mortgage Payment : " + formattedValue);

    }
}
