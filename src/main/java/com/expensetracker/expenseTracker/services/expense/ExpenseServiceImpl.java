package com.expensetracker.expenseTracker.services.expense;

import com.expensetracker.expenseTracker.models.Expense;
import com.expensetracker.expenseTracker.repository.ExpenseRepo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepo expenseRepo;

    @Override
    public Expense createExpense(Expense expenseDetail) {

        return expenseRepo.save(expenseDetail);
    }
    
}
