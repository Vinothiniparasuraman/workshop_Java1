package com.provility.workshop;

import java.util.Scanner;

public class Mortagepayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Principal:");
        Integer principal = sc.nextInt();


            if (principal > 1000 && principal <= 1000000) {
                System.out.println(principal);
                System.out.println("Annual Interest rate");
                Double interest = sc.nextDouble();

                if (interest > 0 && interest < 30) {
                    System.out.println(interest);

                } else {
                    System.out.println("Enter a value greater than 0 and less than or equal to 30");

                }

                System.out.println("Period(Years):");
                Integer payment = sc.nextInt();
                if (payment > 0 && payment <= 30) {
                    System.out.println(payment);
                } else {
                    System.out.println("Enter a value between 1 to 30");

                }
                double rateCal = 1 + interest;
                double power = Math.pow(rateCal, payment);
                double numerator = (interest * power);
                double denominator = power - 1;
                double total = numerator / denominator;
                double monthly = principal * total;

                System.out.println("Mortgage  : $ " + monthly);


            } else {
                System.out.println("Enter a value between greater than 1000 and less than 1000000:");


            }

        }

    }





