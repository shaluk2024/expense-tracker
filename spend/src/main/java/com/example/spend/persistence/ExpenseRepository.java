package com.example.spend.persistence;

import com.example.spend.data.MonthlyExpense;
import com.example.spend.domain.Expense;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    List<Expense> findByOrderByIdDesc();

    @Query("SELECT "+" new com.example.spend.data.MonthlyExpense( MONTH(e.date) AS month, YEAR(e.date) AS year, SUM(e.amount) AS amount, " +
           "CONCAT(MONTHNAME(e.date), ', ', YEAR(e.date)) AS monthYear, currency )" +
           "FROM Expense e " +
           "WHERE e.date >= :startDate AND e.date <= :endDate " +
           "GROUP BY MONTH(e.date), YEAR(e.date), monthYear, currency " +
           "ORDER BY YEAR(e.date) DESC, MONTH(e.date) DESC")
    List<MonthlyExpense> findMonthlyExpenditure(Date startDate, Date endDate);
}
