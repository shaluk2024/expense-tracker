package com.example.spend.persistence;

import com.example.spend.domain.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Repository
public class ExpensePopulator implements CommandLineRunner {
    @Autowired
    private ExpenseRepository expenseTrackerRepository;
    @Override
    public void run(String... args) throws Exception {
        LocalDate date1 = LocalDate.of(2024, 1, 8);
        LocalDate date2 = LocalDate.of(2024, 2, 5);
        LocalDate date3 = LocalDate.of(2024, 2, 6);
        LocalDate date4 = LocalDate.of(2024, 3, 7);
        final var expenses = Arrays.asList(new Expense(new BigDecimal(12000), date1, "Rent")
                , new Expense(new BigDecimal(11000), date2, "Credit Card")
                , new Expense(new BigDecimal(19000), date3, "Fee")
                , new Expense(new BigDecimal(15000), date4, "Rent"));
        expenseTrackerRepository.saveAll(expenses);
    }
}
