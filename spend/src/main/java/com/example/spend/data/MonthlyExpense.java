package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;

import com.example.spend.domain.Currency;

public class MonthlyExpense {

    @Serial
    private static final long serialVersionUID = 1L;

    private final BigDecimal amount;

    private final Currency currency;

    private final Integer month;

    private final String monthYear;

    private final Integer year;

    public MonthlyExpense( final Integer month,  final Integer year, final BigDecimal amount, final String monthYear, final Currency currency) {
        this.amount = amount;
        this.month = month;
        this.monthYear = monthYear;
        this.year = year;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getMonth() {
        return month;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public Integer getYear() {
        return year;
    }

    public Currency getCurrency() {
        return currency;
    }

    
    


    
}
