package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

public class GetExpensesRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private Date date;

    private String description;


    public GetExpensesRequest() {
        super();
    }

    public GetExpensesRequest(final BigDecimal amount, final Date date, final String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
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
}
