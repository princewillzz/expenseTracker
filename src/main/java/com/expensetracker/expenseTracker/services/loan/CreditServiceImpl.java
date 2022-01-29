package com.expensetracker.expenseTracker.services.loan;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.expensetracker.expenseTracker.models.Credit;
import com.expensetracker.expenseTracker.repository.CreditRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    
    private final CreditRepo creditRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Credit> getAllCredits() {
        return creditRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Credit getCreditDetail(UUID creditId) throws NoSuchElementException {
        return creditRepo.findById(creditId).orElseThrow();
    }

    @Override
    @Transactional
    public Credit creditCredit(Credit creditDetail) {
        return creditRepo.save(creditDetail);
    }

    @Override
    @Transactional
    public Credit updateCredit(final UUID creditId, final Credit creditDetail) {
        final Credit credit = creditRepo.findById(creditId).orElseThrow();
        updateFieldToUpdateOfCreditDetails(credit, creditDetail);
        return creditRepo.save(credit);
    }

    private void updateFieldToUpdateOfCreditDetails(final Credit currentCreditDetails, final Credit toBeUpdatedWithCreditDetails) {
        currentCreditDetails.setAmount(toBeUpdatedWithCreditDetails.getAmount());
        currentCreditDetails.setLender(toBeUpdatedWithCreditDetails.getLender());
        currentCreditDetails.setNote(toBeUpdatedWithCreditDetails.getNote());
        currentCreditDetails.setRepaymentDate(toBeUpdatedWithCreditDetails.getRepaymentDate());
    }

    
    @Override
    public void deleteCredit(UUID creditId) throws IllegalArgumentException, NoSuchElementException {
        
        final Credit credit = creditRepo.findById(creditId).orElseThrow();

        creditRepo.delete(credit);
        
    }

    

}
