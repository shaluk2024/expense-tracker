package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

import com.example.spend.domain.Currency;

public class SaveExpenseResponse {
    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private Currency currency;

    private Date date;

    private String description;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    
}
