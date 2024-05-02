package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

import com.example.spend.domain.Currency;

public class SaveExpenseRequest {
    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private Date date;

    private String description;

    private Currency currency;

    public SaveExpenseRequest(final BigDecimal amount, final Date date, final String description, final Currency currency) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Currency getCurrency() {
        return currency;
    }

  

    
}
