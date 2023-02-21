package com.provility.workshop;

import java.util.Scanner;

public class MortagaeCalc {
    public static void main(String[] args) {

        int principal = 0;
        double interest = 0;
        int payment= 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a Principal:");
            principal = sc.nextInt();
            if (principal > 1000 && principal <= 1000000)
                break;

            System.out.println("Enter a value between greater than 1000 and less than 1000000:");
        }

            while (true) {
                System.out.println("Annual Interest rate");
                interest =  sc.nextDouble();
                if (interest > 0 && interest <= 30)
                    break;
                System.out.println("Enter a value greater than 0 and less than or equal to 30");

            }
                while (true) {
                    System.out.println("Period(Years):");
                    payment = sc.nextInt();
                    if (payment > 0 && payment <= 30)
                        break;

                    System.out.println("Enter a value between 1 to 30");
                }
                double rateCal = 1 + interest;
                double power = Math.pow(rateCal, payment);
                double numerator = (interest * power);
                double denominator = power - 1;
                double total = numerator / denominator;
                double monthly = principal * total;

                     System.out.println("Mortgage  : $ " + monthly);

            }
        }


