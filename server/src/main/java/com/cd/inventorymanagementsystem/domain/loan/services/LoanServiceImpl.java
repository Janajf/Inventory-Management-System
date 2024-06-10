package com.cd.inventorymanagementsystem.domain.loan.services;

import com.cd.inventorymanagementsystem.domain.loan.exceptions.LoanException;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.loan.repos.LoanRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {
    private static Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
    private LoanRepo loanRepo;

    @Autowired

    public LoanServiceImpl(LoanRepo loanRepo) {
        this.loanRepo = loanRepo;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepo.save(loan);
    }

    @Override
    public Loan getLoanById(Integer loanId) throws LoanException {
        Optional<Loan> loanOptional = loanRepo.findById(loanId);

        if(loanOptional.isEmpty()){
            logger.error("Loan with {} does not exist", loanId);
            throw new LoanException("Loan not found");
        }
        return loanOptional.get();
    }

    @Override
    public List<Loan> getAllLoans() {
        return (List<Loan>) loanRepo.findAll();
    }

    @Override
    public Loan updateLoanById(Integer loanId, Loan loan) throws LoanException {
        Optional<Loan> loanOptional = loanRepo.findById(loanId);

        if(loanOptional.isEmpty()){
            throw new LoanException("Loan not found, cannot update");
        }

        Loan savedLoan = loanOptional.get();

        savedLoan.setComputer(loan.getComputer());
        savedLoan.setStartDate(loan.getStartDate());
        savedLoan.setEndDate(loan.getEndDate());
        return loanRepo.save(savedLoan);
    }

    @Override
    public Boolean deleteLoanById(Integer loanId) throws LoanException {
        Optional<Loan> loanOptional = loanRepo.findById(loanId);

        if(loanOptional.isEmpty()){
            throw new LoanException("Loan not found, cannot delete");
        }

        Loan loanToDelete = loanOptional.get();
        loanRepo.delete(loanToDelete);
        return true;
    }
}
