package com.provility.workshop;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.nio.charset.StandardCharsets;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;
        import java.util.*;
        import java.util.stream.Collectors;

public class CSVReaderInJava {
    public static <TransactionDetails> void main(String... args) {
        List<TransactionDetails> csvFilesRecords = (List<TransactionDetails>) readBooksFromCSV();
        for (TransactionDetails TransactionRecords : csvFilesRecords) {
            System.out.println(TransactionRecords);
        }
        profitOrLoss((List<CSVRecords>) csvFilesRecords);

    }

    //ProfitOrLoss
    public static  void profitOrLoss(List<CSVRecords> csvFilesRecords) {
        int profit = 0;
        int loss = 0;
        int result = 0;
        for (CSVRecords profitLossCalculation : csvFilesRecords) {

            if (profitLossCalculation.profitOrLose < 0) {
                loss = loss + profitLossCalculation.profitOrLose;


            } else {
                profit = profit + profitLossCalculation.profitOrLose;

            }
        }
        result = profit + loss;
        System.out.println("his total is" + result);
        if (result > 0) {
            System.out.println("Yes,it is POSITIVE");
        } else
            System.out.println("NEGATIVE");

        // ** Bank Transaction based on month


        Map <Object,List<CSVRecords>>transactionDate = csvFilesRecords.stream().collect(
        Collectors.groupingBy(a -> a.date.getMonth()));

        System.out.println(transactionDate);


        for (Map.Entry<Object, List<CSVRecords>> entry1 : transactionDate .entrySet()) {

            int value1 = entry1.getValue().size();
            System.out.println( value1 +" times transaction was happened in "+ entry1.getKey());

        }



        //Top 10 expense
        ArrayList<Integer> topTenExpenses = new ArrayList<>();
        for (CSVRecords expenses : csvFilesRecords) {
            if (expenses.profitOrLose < 0) {
                topTenExpenses.add(expenses.profitOrLose);

            }
        }
        List<Integer> sortedExpenses = topTenExpenses.stream().sorted().toList();
        for (int i = 0; i < sortedExpenses.size(); i++) {
            String spendMoney= String.valueOf(sortedExpenses.get(i));
            if(i<10)
            {
                System.out.println("Top" + i + "Expenses are = " + spendMoney);
            }

        }
        //which category he spent most

        List<CSVRecords>  filter = csvFilesRecords.stream().filter(p -> p.profitOrLose < 0) .toList();
//        System.out.println(filter);
        Map<String ,List <CSVRecords>> filtered = filter.stream().collect(
                Collectors.groupingBy( c-> c.spendFor));
        System.out.println(filtered);

        Map<String,List<CSVRecords>> category= new HashMap(filtered);
        System.out.println(category);

        int maxTimes =0;
        String purpose = "";
        for (Map.Entry<String, List<CSVRecords>> entry : category .entrySet()) {

            List<CSVRecords> value = entry.getValue();
            if( maxTimes < value.size()){
                maxTimes = value.size();
                purpose  =  entry.getKey();
            }

        }
        System.out.println("He spent most of his money on " + purpose);

        }

    private static <TransactionDetails> List<TransactionDetails> readBooksFromCSV() {
        List<TransactionDetails> csvFiles = new ArrayList<>();
        Path pathToFile = Paths.get("bank-data-simple.csv");

        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {

                String[] attributes = line.split(",");
                TransactionDetails book = (TransactionDetails) createBook(attributes);
                csvFiles.add(book);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return csvFiles;
    }

    private static CSVRecords createBook(String[] metadata) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
        LocalDate date = LocalDate.parse(metadata[0],formatter);
        int profitOrLose = Integer.parseInt(metadata[1]);
        String expenses = metadata[2];

        return new CSVRecords(date, profitOrLose, expenses);
    }

}
