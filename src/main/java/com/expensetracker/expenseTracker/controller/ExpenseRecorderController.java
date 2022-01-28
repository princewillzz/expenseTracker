package com.expensetracker.expenseTracker.controller;

import javax.validation.Valid;

import com.expensetracker.expenseTracker.models.Expense;
import com.expensetracker.expenseTracker.services.expense.ExpenseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/expense")
public class ExpenseRecorderController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> createExpense(@Valid @RequestBody final Expense expenseDetail) {

        final Expense expense = expenseService.createExpense(expenseDetail);
        
        return ResponseEntity.ok().body(expense);
    }
    
}
