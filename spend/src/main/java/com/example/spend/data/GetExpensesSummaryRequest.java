package com.example.spend.data;

import java.io.Serial;
import java.math.BigDecimal;

public class GetExpensesSummaryRequest {

    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal amount;

    private String monthYear;

    

    public GetExpensesSummaryRequest() {
        super();
    }

    public GetExpensesSummaryRequest(final BigDecimal amount, final String monthYear) {
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
