package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;

public class ExpensesSummary {
    @Serial
    private static final long serialVersionUID = 1L;

    private final BigDecimal amount;

    private final String monthYear;

    public ExpensesSummary(final BigDecimal amount, final String monthYear) {
        this.amount = amount;
        this.monthYear = monthYear;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMonthYear() {
        return monthYear;
    }
    

}
