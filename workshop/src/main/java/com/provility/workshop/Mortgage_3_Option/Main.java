package com.provility.workshop.Mortgage_3_Option;

import java.sql.ResultSet;
import java.util.Scanner;

import static com.provility.workshop.Mortgage_3_Option.Mortgagerecords.fetchRecords;

public class Main {
    public static void main(String arg[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a choice");
        System.out.println("1 Enter the mortgage records details ");
        System.out.println("2.Get particular customer record");
        System.out.println("3.Exit");
        int input = sc.nextInt();
        while (true) {
            if (input == 1) {
                getInput();
            }
            if (input== 2){
                Scanner customerid = new Scanner(System.in);
                System.out.println("Enter a customerId:");
                int enterId = customerid.nextInt();
                fetchRecords(enterId);
                break;
            }
            if (input==3){
                System.out.println("exit");
            }


        }
    }

public static void getInput() throws Exception {
     Scanner sc = new Scanner(System.in);
     System.out.println("CustomerName");
     String customerName= sc.next();
     int principle = (int)Mortgagerecords.checkOnlyAllows("Principal",1000,1000000);
     float interest = Mortgagerecords.checkOnlyAllows("Interest",1,30);
     int years = (int)Mortgagerecords.checkOnlyAllows("Years",1,30);
     Mortgagerecords mortgagerecords = new Mortgagerecords(customerName,principle,interest,years);
     String mortgage_monthly= mortgagerecords.calculateMonthly();
     mortgagerecords.insertINTOdb(customerName,principle,interest,years);
     int customerid = mortgagerecords.getCustomerId();
     mortgagerecords.insertINTOMonthly(mortgage_monthly,customerid);
}
}
