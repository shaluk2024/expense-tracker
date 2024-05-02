package com.example.spend.persistence;

import com.example.spend.domain.Currency;
import com.example.spend.domain.Expense;
import com.example.spend.service.CurrencyConversionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.text.SimpleDateFormat;  

@Repository
public class ExpensePopulator implements CommandLineRunner {
    @Autowired
    private ExpenseRepository expenseTrackerRepository;

    @Autowired
    private CurrencyConversionService currencyConversionService;
    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Map<String, Double> rates = currencyConversionService.fetchExchangeRatesFromApi();


        final var expenses = Arrays.asList(new Expense("Rent", sdf.parse("2024-01-05"), currencyConversionService.convertCurrencyToUSD(new BigDecimal(12000), "INR", "USD", rates), Currency.INR)
                , new Expense("Credit Card", sdf.parse("2024-02-04"), currencyConversionService.convertCurrencyToUSD(new BigDecimal(11000), "INR", "USD", rates), Currency.INR)
                , new Expense("Fee", sdf.parse("2024-02-19"), currencyConversionService.convertCurrencyToUSD(new BigDecimal(19000), "INR", "USD", rates), Currency.INR)
                , new Expense("Rent", sdf.parse("2024-03-14"), currencyConversionService.convertCurrencyToUSD( new BigDecimal(15000), "INR", "USD", rates), Currency.INR)
                , new Expense("Shopping", sdf.parse("2024-04-11"), currencyConversionService.convertCurrencyToUSD(new BigDecimal(17000), "INR", "USD", rates), Currency.INR));
        expenseTrackerRepository.saveAll(expenses);
    }
}
