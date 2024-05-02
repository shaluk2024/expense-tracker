package com.example.spend.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.example.spend.data.GetExpensesRequest;
import com.example.spend.data.GetExpensesResponse;
import com.example.spend.data.GetExpensesSummaryRequest;
import com.example.spend.data.GetExpensesSummaryResponse;
import com.example.spend.data.MonthlyExpense;
import com.example.spend.data.SaveExpenseRequest;
import com.example.spend.data.SaveExpenseResponse;
import com.example.spend.domain.Currency;
import com.example.spend.domain.Expense;
import com.example.spend.persistence.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ExpenseServiceTests {
    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetExpenses() {

               // Mock data
               List<Expense> expenses = new ArrayList<>();
               expenses.add(new Expense( "Expense 1", new Date(), BigDecimal.valueOf(100), Currency.INR));
               expenses.add(new Expense("Expense 2", new Date(), BigDecimal.valueOf(200), Currency.INR));
       
               // Mock repository behavior
               when(expenseRepository.findByOrderByIdDesc()).thenReturn(expenses);
       
               // Call the service method
               GetExpensesResponse response = expenseService.getExpenses(new GetExpensesRequest());
       
               // Verify response
               assertNotNull(response);
               assertEquals(2, response.getExpenses().size());

    }

    @Test
    void testGetMonthlyExpenses() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        Date startDate;
        try {
            startDate = sdf.parse("2024-02-01");
            List<MonthlyExpense> expenses = new ArrayList<>();
            expenses.add(new MonthlyExpense( 2, 2024, BigDecimal.valueOf(100), "February, 2024", Currency.INR));
            expenses.add(new MonthlyExpense( 3, 2024, BigDecimal.valueOf(100), "March, 2024", Currency.INR));
            // expenses.add(new Expense(BigDecimal.valueOf(200), LocalDate.of(2024, 1, 20), "Expense 3"));
    
    
            // Mock repository behavior
            when(expenseRepository.findMonthlyExpenditure(startDate, new Date())).thenReturn(expenses);
    
            // Call the service method
            GetExpensesSummaryResponse response = expenseService.getMonthlyExpenses(new GetExpensesSummaryRequest());
    
            // Verify response
            assertNotNull(response);
            assertEquals(2, response.getExpenses().size());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Test
    void testSaveExpense() {

        SaveExpenseRequest request = new SaveExpenseRequest(BigDecimal.valueOf(300), new Date(), "New Expense", Currency.INR);

        // Call the service method
        SaveExpenseResponse response = expenseService.saveExpense(request);

        // Verify response
        assertNotNull(response);
        assertEquals(BigDecimal.valueOf(300), response.getAmount());
        assertEquals(LocalDate.now(), response.getDate());
        assertEquals("New Expense", response.getDescription());

    }
}
