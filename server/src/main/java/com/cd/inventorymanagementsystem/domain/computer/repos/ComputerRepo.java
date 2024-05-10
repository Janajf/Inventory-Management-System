package com.cd.inventorymanagementsystem.domain.computer.repos;

import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepo extends JpaRepository<Computer, Integer> {
}
