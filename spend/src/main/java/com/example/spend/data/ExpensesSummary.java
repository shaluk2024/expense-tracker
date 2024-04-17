package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpensesSummary {
    @Serial
    private static final long serialVersionUID = 1L;

    private final BigDecimal amount;

    private final LocalDate date;

    private final String description;

    public ExpensesSummary(final BigDecimal amount, final LocalDate date, final String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    

    

}
