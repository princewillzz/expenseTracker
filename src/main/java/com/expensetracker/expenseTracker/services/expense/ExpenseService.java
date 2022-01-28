package com.expensetracker.expenseTracker.services.expense;

import com.expensetracker.expenseTracker.models.Expense;

public interface ExpenseService {

    Expense createExpense(Expense expenseDetail);
    
}
