package com.cd.inventorymanagementsystem.domain.computer.services;

import com.cd.inventorymanagementsystem.domain.computer.exceptions.ComputerException;
import com.cd.inventorymanagementsystem.domain.computer.models.Computer;

import java.util.List;

public interface ComputerService {
    Computer createComputer(Computer computer);
    Computer getComputerById(Integer computerId) throws ComputerException;
    List<Computer> getAllComputers();
    Computer updateComputerById(Integer computerId, Computer computer) throws ComputerException;
    Boolean deleteComputerById(Integer computerId) throws ComputerException;

}
