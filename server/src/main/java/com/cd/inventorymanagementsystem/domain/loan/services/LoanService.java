package com.cd.inventorymanagementsystem.domain.loan.services;

import com.cd.inventorymanagementsystem.domain.loan.exceptions.LoanException;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;

import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);
    Loan getLoanById(Integer loanId) throws LoanException;
    List<Loan> getAllLoans();
    Loan updateLoanById(Integer loanId, Loan loan) throws LoanException;
    Boolean deleteLoanById(Integer loanId) throws LoanException;
}
