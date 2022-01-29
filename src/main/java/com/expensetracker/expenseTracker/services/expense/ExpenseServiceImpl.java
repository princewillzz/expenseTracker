package com.expensetracker.expenseTracker.services.expense;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.expensetracker.expenseTracker.models.Expense;
import com.expensetracker.expenseTracker.repository.ExpenseRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepo expenseRepo;

    @Override
    public Expense createExpense(final Expense expenseDetail) {

        return expenseRepo.save(expenseDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public Expense getExpense(final UUID expenseId) throws NoSuchElementException {
        
        return expenseRepo.findById(expenseId).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    @Override
    public void deleteExpense(UUID expenseId) throws IllegalArgumentException, NoSuchElementException {
        
        final Expense expense = expenseRepo.findById(expenseId).orElseThrow();

        expenseRepo.delete(expense);;
        
    }

    @Override
    @Transactional
    public Expense updateExpense(UUID expenseId, Expense expenseDetail) {
        
        // Get the expense with given id
        final Expense expense = expenseRepo.findById(expenseId).orElseThrow();

        // Update the fields that can be updated
        updateExpenseFieldsToBeUpdated(expense, expenseDetail);

        // Save the updated expense 
        expenseRepo.save(expense);

        // Return the updated expense model
        return expense;
    }

    private void updateExpenseFieldsToBeUpdated(final Expense currentExpense, final Expense toBeUpdatedExpenseDetails) {
        currentExpense.setAmount(toBeUpdatedExpenseDetails.getAmount());
        currentExpense.setDescription(toBeUpdatedExpenseDetails.getDescription());
        currentExpense.setLocation(toBeUpdatedExpenseDetails.getLocation());
        currentExpense.setPaymentMethod(toBeUpdatedExpenseDetails.getPaymentMethod());
        currentExpense.setReason(toBeUpdatedExpenseDetails.getReason());
    }
    
}
