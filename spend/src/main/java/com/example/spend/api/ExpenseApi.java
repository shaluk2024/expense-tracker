package com.example.spend.api;

import com.example.spend.data.*;
import com.example.spend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RequestMapping("/expenses")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseApi {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public ResponseEntity<GetExpensesResponse> getExpenses(final BigDecimal amount
            , final Date date
            , final String description) {
        return ResponseEntity.ok(expenseService.getExpenses(new GetExpensesRequest(amount
                , date
                , description)));
    }

    // @GetMapping("/summary")
    // public ResponseEntity<GetMonthNameResponse> getMonthlyExpenditure(){
    //     return ResponseEntity.ok(expenseService.getMonthlyExpenditure());
    // }

    @GetMapping("/summary")
    public ResponseEntity<GetExpensesSummaryResponse> getMonthlyExpenses(final BigDecimal amount
            , final String monthYear){
        return ResponseEntity.ok(expenseService.getMonthlyExpenses(new GetExpensesSummaryRequest(amount, monthYear)));
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public ResponseEntity<SaveExpenseResponse> save(@RequestBody final SaveExpenseRequest request){
        final  var response = expenseService.saveExpense(request);

        return ResponseEntity.ok(response);
    }
}
