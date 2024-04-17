package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

public class GetExpensesSummaryRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private Date date;

    public GetExpensesSummaryRequest(final BigDecimal amount, final Date date) {
        this.amount = amount;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

}
