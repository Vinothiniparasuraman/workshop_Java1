package com.provility.workshop.mortgage;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;



public class Mortgage_cal {
public static  void main(String[] arg) {
    List<mortageRecords> csvFilesRecords = readRecordsFromCSV();
    for (mortageRecords MortgageRecords : csvFilesRecords) {
        System.out.println(MortgageRecords);
    }
    monthlyCalculate(csvFilesRecords);
}
    public static  void monthlyCalculate(List<mortageRecords> csvFilesRecords) {
        for (mortageRecords monthlyCalculate : csvFilesRecords){
            double rateCal = 1+ monthlyCalculate.annualInterest/100/12;
            double power = Math.pow(rateCal, monthlyCalculate.period*12);
            double numerator = (rateCal * power);
            double denominator = power - 1;
            double total = numerator / denominator;
            double monthlyMortgageValue = monthlyCalculate.principle * total;
            String formattedValue = NumberFormat.getCurrencyInstance().format(monthlyMortgageValue);
            System.out.println(" The monthly mortgage value for " + monthlyCalculate.name  + " is " + formattedValue +
                    " with Principle:" + monthlyCalculate.principle + " Annual Interest  :"
            + monthlyCalculate.annualInterest + " Period(Years):"+ monthlyCalculate.period);
        }
    }

private static  List<mortageRecords> readRecordsFromCSV() {
            List<mortageRecords> csvFiles = new ArrayList<>();
            Path pathToFile = Paths.get("mortgateexcel.csv");

            try (BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII)) {
                String line = br.readLine();
                while (line != null) {

                    String[] attributes = line.split(",");
                    mortageRecords book =  createRecords(attributes);
                    csvFiles.add(book);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return csvFiles;



    }
    public static mortageRecords createRecords(String[] records){
        String name = records[0];
        int principle = Integer.parseInt(records[1]);
        float annualInterest = Float.parseFloat(records[2]);
        int period = Integer.parseInt(records[3]);
        return new mortageRecords (name,principle,annualInterest,period);
    }
}

