package com.expensetracker.expenseTracker.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.expensetracker.expenseTracker.models.Expense;
import com.expensetracker.expenseTracker.services.expense.ExpenseService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    // Get all expenses
    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {

        return ResponseEntity
            .ok()
            .body(expenseService.getAllExpenses());

    }


    // Get a expense with id
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseWithId(@PathVariable(name = "id") final UUID expenseId) {

        return ResponseEntity.ok(
            expenseService.getExpense(expenseId)
        );
    }

    // Create a expense
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody final Expense expenseDetail) {

        final Expense expense = expenseService.createExpense(expenseDetail);
        
        return ResponseEntity.ok().body(expense);
    }

    // Update a given expense
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
        @PathVariable(name = "id") final UUID expenseId,
        @Valid @RequestBody final Expense expenseDetail
    ) {

        final Expense expense = expenseService.updateExpense(expenseId, expenseDetail);

        return ResponseEntity
            .ok()
            .body(expense);
    }

    // Delete an expense with id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseWithId(@PathVariable(name = "id") final UUID expenseId) {

        expenseService.deleteExpense(expenseId);

        return ResponseEntity
            .ok()
            .body("Successfully Deleted!!");
    }
    
}
