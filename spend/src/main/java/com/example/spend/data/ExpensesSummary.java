package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;

import com.example.spend.domain.Currency;

public class ExpensesSummary {
    @Serial
    private static final long serialVersionUID = 1L;

    private final BigDecimal amount;

    private final Currency currency;

    private final String monthYear;

    public ExpensesSummary(final BigDecimal amount, final String monthYear, final Currency currency) {
        this.amount = amount;
        this.monthYear = monthYear;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public Currency getCurrency() {
        return currency;
    }

    
    

}
