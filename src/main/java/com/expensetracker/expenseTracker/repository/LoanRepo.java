package com.expensetracker.expenseTracker.repository;

import java.util.UUID;

import com.expensetracker.expenseTracker.models.Loan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, UUID> {
    
}
