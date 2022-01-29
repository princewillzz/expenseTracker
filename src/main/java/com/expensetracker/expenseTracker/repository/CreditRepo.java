package com.expensetracker.expenseTracker.repository;

import java.util.UUID;

import com.expensetracker.expenseTracker.models.Credit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepo extends JpaRepository<Credit, UUID> {
    
}
