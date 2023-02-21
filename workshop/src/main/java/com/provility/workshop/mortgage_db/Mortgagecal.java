package com.provility.workshop.mortgage_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Mortgagecal {
    static String name;
    static int principal;
    static float interest;
    static int years;

  static String jdbcURL = "jdbc:postgresql://localhost:5432/mortgagedb";
  static String userName = "ems";
  static String passWord = "ems";

    public Mortgagecal(String name, int principal, float interest, int years) {
        Mortgagecal.name = name;
        Mortgagecal.principal = principal;
        Mortgagecal.interest = interest;
        Mortgagecal.years = years;



    }
    public static float calculateMonthly(String prompt1, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(prompt1);
            float value = sc.nextFloat();
            if (value > min && value < max) {
                return value;
            }
            System.out.println("Enter a value between " + min + " and " + max);

        }

    }

    public  double calculateMonthyMortagevalue() {
        double rateCal = 1 + interest;
        double power = Math.pow(rateCal, years);
        double numerator = (interest * power);
        double denominator = power - 1;
        double total = numerator / denominator;
        double monthly = principal * total;

        System.out.println("Mortgage  : $ " + monthly);
        return monthly;

    }




    public  void insertINTOdb(String name, int principle, float interest, int years,double mortageMonthly) throws Exception {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, userName, passWord);
        String sql = "INSERT INTO public.mortgage VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, principle);
        preparedStatement.setFloat(3, interest);
        preparedStatement.setInt(4, years);
        preparedStatement.setDouble(5, mortageMonthly);

        preparedStatement.executeUpdate();
    }
}
