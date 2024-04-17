package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SaveExpenseRequest {
    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private LocalDate date;

    private String description;

    public SaveExpenseRequest(final BigDecimal amount, final LocalDate date, final String description) {
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
