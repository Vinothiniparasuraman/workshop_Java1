package com.provility.workshop.Mortgage_3_Option;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgagerecords {
    String customerName;
    int principal;
    float interest;
    int years;
    String jdbcURL = "jdbc:postgresql://localhost:5432/mortgagedb_3choice";
    String userName = "ems";
    String passWord = "ems";

    public Mortgagerecords(String customerName, int principal, float interest, int years){
        this.customerName=customerName;
        this.principal=principal;
        this.interest=interest;
        this.years=years;

    }

    public static float checkOnlyAllows(String prompt,int min, int max){
        Scanner sc1= new Scanner(System.in);
       while (true){
           System.out.println(prompt);
           float value = sc1.nextFloat();
           if(value>=min && value<=max){
               return value;
           }
           System.out.println("Enter a value between "+ min +"and"+max);
       }



    }
    public  String  calculateMonthly(){
        double rateCal = interest/100/12;
        double numerator = years*12;
        double power = Math.pow(1 + rateCal,numerator);
        double monthlyPayment = principal * (rateCal*power / (power-1));
        String monthly = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Mortgage  : $ " + monthly);
        return monthly;
    }

    public  void insertINTOdb(String customerName,int principal,
                                    float interest,int  years ) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, userName, passWord);
        String sql = "INSERT INTO public.mortgage_info_value VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customerName);
        preparedStatement.setInt(2, principal);
        preparedStatement.setFloat(3, interest);
        preparedStatement.setInt(4, years);
        preparedStatement.executeUpdate();

    }
    public void insertINTOMonthly(String mortgage_monthly ,int customerId) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection2 = DriverManager.getConnection(jdbcURL, userName, passWord);
        String sql2 = "INSERT INTO public.mortgage_monthly (mortgage_monthly, customer_id) Values (?,?)";
        PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
        preparedStatement2.setString(1,mortgage_monthly);
        preparedStatement2.setInt(2,customerId);
        preparedStatement2.execute();

    }
    public int getCustomerId() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, userName, passWord);
        int customerId = 0;
        String sql3 = "SELECT customer_id FROM public.mortgage_info_value";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()){
            customerId = rs.getInt("customer_id");
        }
        return customerId;


    }
    public static void fetchRecords(int enterId) throws Exception {
        String jdbcURL = "jdbc:postgresql://localhost:5432/mortgagedb_3choice";
        String userName = "ems";
        String passWord = "ems";
        Class.forName("org.postgresql.Driver");
        Connection connection4 = DriverManager.getConnection(jdbcURL, userName, passWord);
        String sql4 = "SELECT e.*,r.mortgage_monthly  FROM public.mortgage_info_value e INNER JOIN " +
                "public.mortgage_monthly  r ON e.customer_id = "+ enterId + "AND r.customer_id = "+ enterId ;

        //        String sql4 = "SELECT e.*,r.mortgage_monthly  FROM public.mortgage_info_value e ,public.mortgage_monthly  r WHERE e.customer_id = "+ enterId + "AND r.customer_id = "+ enterId ;

        Statement stmt = connection4.createStatement();
        ResultSet rs1 = stmt.executeQuery(sql4);


        while (rs1.next()){
            System.out.println( " customer_name" + ":"+ rs1.getString("customer_name") + "\t"
            + " principle" + ":"+ rs1.getInt("principle") + "\t"+
           " interest"+":"+  rs1.getFloat("interest") +"\t"+
           "years"+ ":"+ rs1.getInt("years") +"\t"+
            " mortgage_monthly" +":" +rs1.getString("mortgage_monthly")
            );
        }

    }

}

