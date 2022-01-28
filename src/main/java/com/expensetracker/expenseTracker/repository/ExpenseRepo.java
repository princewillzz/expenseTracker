package com.expensetracker.expenseTracker.repository;

import java.util.UUID;

import com.expensetracker.expenseTracker.models.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, UUID> {
    
}
