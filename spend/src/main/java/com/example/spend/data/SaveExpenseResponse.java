package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SaveExpenseResponse {
    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private LocalDate date;

    private String description;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
