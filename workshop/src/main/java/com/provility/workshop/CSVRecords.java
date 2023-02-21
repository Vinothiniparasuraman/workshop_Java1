package com.provility.workshop;

import java.time.LocalDate;

public class CSVRecords {

    LocalDate date;
    int profitOrLose;
    String spendFor;

    public CSVRecords(LocalDate date, int profitOrLose, String spendFor) {
        this.date = date;
        this.profitOrLose = profitOrLose;
        this.spendFor = spendFor;
    }



    public String toString() {
        return "Date=" + date + ", ProfitOrLose=" + profitOrLose + ", SpendFor=" + spendFor ;
    }

}
