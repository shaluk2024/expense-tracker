package com.example.spend.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetExpensesResponse {
    private Collection<ExpensesDetails> expenses;

    public void addExpense(final ExpensesDetails expense) {
        if (expenses == null) {
            expenses = new ArrayList<>();
        }

        expenses.add(expense);
    }

    public Collection<ExpensesDetails> getExpenses() {
        return expenses;
    }
}
