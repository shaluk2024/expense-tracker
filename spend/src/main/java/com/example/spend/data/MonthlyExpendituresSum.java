package com.example.spend.data;

import java.math.BigDecimal;

public class MonthlyExpendituresSum {

    private int month;
    private int year;
    private BigDecimal sum;


    public MonthlyExpendituresSum(int month,int year,BigDecimal sum) {
        this.month=month;
        this.year=year;
        this.sum = sum;
    }

    public int getMonth() {
        return month;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public int getYear(){
        return year;
    }
    
}
