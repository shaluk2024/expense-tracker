package com.example.spend.persistence;

import com.example.spend.domain.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    Expense findFirstByOrderByDateDesc();

    List<Expense> findByOrderByIdDesc();

    List<Expense> findByDateGreaterThanEqualOrderByDateDesc(LocalDate startDate);
}
