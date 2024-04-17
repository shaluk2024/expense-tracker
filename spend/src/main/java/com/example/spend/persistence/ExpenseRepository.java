package com.example.spend.persistence;

import com.example.spend.data.MonthlyExpendituresSum;
import com.example.spend.domain.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

  
    @Query(
            value =
                  "SELECT "+" new com.example.spend.data.MonthlyExpendituresSum(extract(month from e.date),extract(year from e.date),SUM(e.amount))"+
                 "FROM Expense e "+
                 "GROUP BY extract(month from e.date),extract(year from e.date) ORDER BY extract(year from e.date) DESC, extract(month from e.date) DESC"

    )
    public List<MonthlyExpendituresSum> findGroupByMonthTotalExpenditure();

    Expense findFirstByOrderByDateDesc();

    List<Expense> findByOrderByIdDesc();
}
