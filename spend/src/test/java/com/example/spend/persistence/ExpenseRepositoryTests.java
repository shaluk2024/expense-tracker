package com.example.spend.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spend.domain.Currency;
import com.example.spend.domain.Expense;

@SpringBootTest
public class ExpenseRepositoryTests {

    @Autowired
    private ExpenseRepository subject;

    @BeforeEach
    public void setUp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse("2024-01-05");
            subject.save(new Expense("Credit Card", date, new BigDecimal(11000), Currency.INR));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testDependenciesInjected(){
        assertNotNull(subject);
    }

    @Test
    void testFindByDateGreaterThanEqualOrderByDateDesc() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        try {
            date = sdf.parse("2024-02-01");
            final var expenses = subject.findMonthlyExpenditure(date, new Date());

            assertNotNull(expenses);

            assertTrue(expenses.iterator().hasNext());
    
            for (final var expense : expenses) {
                assertNotNull(expense);
                assertNotNull(expense.getAmount());
                assertNotNull(expense.getMonthYear());
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    @Test
    void testFindByOrderByIdDesc() {

        final var expenses = subject.findByOrderByIdDesc();

        assertNotNull(expenses);

        assertTrue(expenses.iterator().hasNext());

        for (final var expense : expenses) {
            assertNotNull(expense);
            assertNotNull(expense.getAmount());
            assertNotNull(expense.getDate());
            assertNotNull(expense.getDescription());
        }

    }
}
