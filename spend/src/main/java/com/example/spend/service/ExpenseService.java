package com.example.spend.service;

import com.example.spend.data.*;
import com.example.spend.domain.Expense;
import com.example.spend.persistence.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CurrencyConversionService currencyConversionService;

    public GetExpensesResponse getExpenses(final GetExpensesRequest request) {
        final var response = new GetExpensesResponse();

        Map<String, Double> rates = currencyConversionService.fetchExchangeRatesFromApi();

        for (final var expense : expenseRepository.findByOrderByIdDesc()) {

            BigDecimal convertedAmount = currencyConversionService.convertCurrency(expense.getAmount(), "USD", "INR", rates);

            response.addExpense(new ExpensesDetails(convertedAmount.setScale(2, RoundingMode.UP)
                    , expense.getDate()
                    , expense.getDescription()
                    , expense.getCurrency()));
        }

        return response;
    }

    public SaveExpenseResponse saveExpense(final SaveExpenseRequest request){
        //System.out.println("date: " + request.getDate());
        //System.out.println("date: " + Date.from(request.getDate().toInstant()));

        Map<String, Double> rates = currencyConversionService.fetchExchangeRatesFromApi();

        BigDecimal convertedAmount = currencyConversionService.convertCurrencyToUSD(request.getAmount(), request.getCurrency().toString(), "USD", rates);

        Expense expense = new Expense(request.getDescription(), request.getDate() , convertedAmount, request.getCurrency());
        expenseRepository.save(expense);

        final var response = new SaveExpenseResponse();
        response.setAmount(expense.getAmount());
        response.setDate(expense.getDate());
        response.setDescription(expense.getDescription());
        response.setCurrency(expense.getCurrency());

        return  response;


    }

    public GetExpensesSummaryResponse getMonthlyExpenses(GetExpensesSummaryRequest request) {
        final  var  response = new GetExpensesSummaryResponse();

       Date currentDate = new Date();

       Calendar calendar = Calendar.getInstance();
       calendar.setTime(currentDate);

       calendar.add(Calendar.MONTH, -2);

       calendar.set(Calendar.DAY_OF_MONTH, 1);

       Date startDate = calendar.getTime();

       Date endDate = currentDate;

       final  List<MonthlyExpense> expenses = expenseRepository.findMonthlyExpenditure(startDate, endDate);

       Map<String, Double> rates = currencyConversionService.fetchExchangeRatesFromApi();


        for (final var expense : expenses) {
            if(expense.getAmount() != null && expense.getMonthYear() != null){

                BigDecimal convertedAmount = currencyConversionService.convertCurrency(expense.getAmount(), "USD", "INR", rates);

                response.addExpense(new ExpensesSummary(convertedAmount.setScale(0, RoundingMode.UP), expense.getMonthYear(), expense.getCurrency()));

            }
    
        }    

        return response;
    }




}
