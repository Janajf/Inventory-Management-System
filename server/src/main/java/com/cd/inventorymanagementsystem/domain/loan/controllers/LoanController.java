package com.cd.inventorymanagementsystem.domain.loan.controllers;

import com.cd.inventorymanagementsystem.domain.loan.exceptions.LoanException;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.loan.services.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {
    private final Logger logger = LoggerFactory.getLogger(LoanController.class);
    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        Loan savedLoan = loanService.createLoan(loan);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLoanById(@PathVariable Integer id){
        try{
            Loan loan = loanService.getLoanById(id);
            ResponseEntity<?> response = new ResponseEntity<>(loan, HttpStatus.OK);
            return response;
        }catch (LoanException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> loans = loanService.getAllLoans();
        ResponseEntity<List<Loan>> response = new ResponseEntity<>(loans, HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLoan(@PathVariable Integer id, @RequestBody Loan loan){
        try{
            Loan updatedLoan = loanService.updateLoanById(id, loan);
            ResponseEntity response = new ResponseEntity<>(updatedLoan, HttpStatus.OK);
            return response;
        }catch(LoanException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoad(@PathVariable Integer id) {
        try {
            loanService.deleteLoanById(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (LoanException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
