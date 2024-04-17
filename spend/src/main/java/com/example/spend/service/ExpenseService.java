package com.example.spend.service;

import com.example.spend.data.*;
import com.example.spend.domain.Expense;
import com.example.spend.persistence.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public GetExpensesResponse getExpenses(final GetExpensesRequest request) {
        final var response = new GetExpensesResponse();

        for (final var expense : expenseRepository.findByOrderByIdDesc()) {
            System.out.println(expense.getAmount());
            System.out.println(expense.getDate());
            System.out.println(expense.getDescription());

            response.addExpense(new ExpensesDetails(expense.getAmount()
                    , expense.getDate()
                    , expense.getDescription()));
        }

        return response;
    }

    public GetMonthNameResponse getMonthlyExpenditure() {
        final var response = new GetMonthNameResponse();

        List<MonthlyExpendituresSum> expenditures = expenseRepository.findGroupByMonthTotalExpenditure();

        for (final var monthlyExpenditure : expenditures) {


            String monthAndYear= Month.of(monthlyExpenditure.getMonth()).name().substring(0, 3) + "," + monthlyExpenditure.getYear();

            response.addExpenditure(new GetExpensesByMonthNameSummary(monthAndYear, monthlyExpenditure.getSum()));

        }
        return response;
    }



    public SaveExpenseResponse saveExpense(final SaveExpenseRequest request){
        Expense expense = new Expense(request.getAmount(), request.getDate(), request.getDescription());
        expenseRepository.save(expense);

        final var response = new SaveExpenseResponse();
        response.setAmount(request.getAmount());
        response.setDate(request.getDate());
        response.setDescription(request.getDescription());

        return  response;


    }

}
