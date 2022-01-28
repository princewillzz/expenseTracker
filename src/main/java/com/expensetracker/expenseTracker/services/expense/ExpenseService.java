package com.expensetracker.expenseTracker.services.expense;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.expensetracker.expenseTracker.models.Expense;

public interface ExpenseService {

    List<Expense> getAllExpenses();
    
    Expense getExpense(UUID expenseId) throws NoSuchElementException;
    
    Expense createExpense(Expense expenseDetail);

    Expense updateExpense(UUID expenseId, Expense expenseDetail);

    void deleteExpense(UUID expenseId) throws IllegalArgumentException, NoSuchElementException;
    
}
