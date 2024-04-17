package com.example.spend.data;

import java.math.BigDecimal;

public class GetExpensesByMonthNameSummary {

    String monthName;


    BigDecimal totalSum;

    public GetExpensesByMonthNameSummary(final String monthName,final BigDecimal totalSum) {
        this.monthName = monthName;
        this.totalSum = totalSum;
    }


       public String getMonthName() {
           return monthName;
       }

       public BigDecimal getTotalSum(){
        return totalSum;
       }


   }
