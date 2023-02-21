package com.provility.workshop.mortgage_db;
import java.util.Scanner;


public class Main {

 public static void main(String[] arg) throws Exception {
     Scanner sc = new Scanner(System.in);
     System.out.println("1 Enter the mortgage records details ");
     System.out.println("2.Exit");
     int input = sc.nextInt();
     while (true) {
         if (input == 1) {
             accessInput();
         } else {
             System.out.println("exit");
         }
     }
 }
    public static void accessInput() throws Exception {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter a name");
        String name = sc1.next();
        int principal = (int) Mortgagecal.calculateMonthly("Principal", 1000, 1000000);
        float interest = Mortgagecal.calculateMonthly("AnnualInterest ", 0, 30);
        int years = (int) Mortgagecal.calculateMonthly("period(Years)", 1, 30);
        Mortgagecal mortgagecal = new Mortgagecal(name, principal, interest, years);
        double mortageMonthly = mortgagecal.calculateMonthyMortagevalue();
        mortgagecal.insertINTOdb(name, principal, interest, years,mortageMonthly);


    }
}





