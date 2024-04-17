package com.example.spend.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetExpensesSummaryResponse {
    private Collection<ExpensesSummary> expenses;

    public void addExpense(final ExpensesSummary expense) {
        if (expenses == null) {
            expenses = new ArrayList<>();
        }

        expenses.add(expense);
    }

    public Collection<ExpensesSummary> getExpenses() {
        return expenses;
    }
}
