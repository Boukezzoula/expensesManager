package com.boukezzoula.expensesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boukezzoula.expensesmanager.entity.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

}
