package com.cd.inventorymanagementsystem.domain.loan.repos;

import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepo extends JpaRepository<Loan, Integer> {
}
