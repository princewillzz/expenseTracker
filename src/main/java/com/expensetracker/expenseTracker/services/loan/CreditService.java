package com.expensetracker.expenseTracker.services.loan;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.expensetracker.expenseTracker.exceptions.InvalidAlgorithmException;
import com.expensetracker.expenseTracker.models.Credit;

public interface CreditService {

    List<Credit> getAllCredits();

    Credit getCreditDetail(UUID creditId) throws NoSuchElementException;
    
    Credit creditCredit(Credit creditDetail);

    Credit updateCredit(UUID creditId, Credit creditDetail);

    void deleteCredit(UUID creditId) throws IllegalArgumentException, NoSuchElementException;
    
    List<Credit> repaymentListWithAlgo(String repaymentAlgo) throws InvalidAlgorithmException;
}
