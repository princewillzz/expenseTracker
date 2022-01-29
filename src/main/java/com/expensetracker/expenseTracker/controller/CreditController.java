package com.expensetracker.expenseTracker.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.expensetracker.expenseTracker.models.Credit;
import com.expensetracker.expenseTracker.services.loan.CreditService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditController {
    
    private final CreditService creditService;

    @PostMapping
    public ResponseEntity<Credit> createDueCreditDetail(@Valid @RequestBody final Credit creditDetail) {

        final Credit credit = creditService.creditCredit(creditDetail);

        return ResponseEntity.ok().body(credit);
    }


    @GetMapping
    public ResponseEntity<List<Credit>> getAllDues() {
        return ResponseEntity.ok().body(creditService.getAllCredits());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Credit> getCreditInfo(@PathVariable(name = "id") final UUID creditId) {

        return ResponseEntity.ok().body(creditService.getCreditDetail(creditId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCreditInfo(@PathVariable(name = "id") final UUID creditId) {

        creditService.deleteCredit(creditId);

        return ResponseEntity.ok().body("Successfully Deleted!!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Credit> updateCreditInfo(@PathVariable(name = "id") final UUID creditId, @Valid @RequestBody final Credit creditDetail) {
        return ResponseEntity.ok().body(creditService.updateCredit(creditId, creditDetail));
    }

    @GetMapping("/repayment")
    public ResponseEntity<List<Credit>> getRepaymentToBeMadeBasedOnAlgo(@RequestParam(name = "algo") final String repaymentAlgo) {


        return ResponseEntity.ok().body(creditService.repaymentListWithAlgo(repaymentAlgo));
    }


}
