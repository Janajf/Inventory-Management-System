package com.cd.inventorymanagementsystem.domain.computer.services;

import com.cd.inventorymanagementsystem.domain.computer.exceptions.ComputerException;
import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.computer.repos.ComputerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService{
    private static Logger logger = LoggerFactory.getLogger(ComputerServiceImpl.class);
    private ComputerRepo computerRepo;

    @Autowired
    public ComputerServiceImpl(ComputerRepo computerRepo) {
        this.computerRepo = computerRepo;
    }

    @Override
    public Computer createComputer(Computer computer) {
        Computer createdComputer = computerRepo.save(computer);
        return createdComputer;
    }

    @Override
    public Computer getComputerById(Integer computerId) throws ComputerException {
        Optional<Computer> computerOptional = computerRepo.findById(computerId);

        if(computerOptional.isEmpty()){
            logger.error("Computer with {} does not exist", computerId);
            throw new ComputerException("Computer not found");
        }
        return computerOptional.get();
    }

    @Override
    public List<Computer> getAllComputers() {
        return (List<Computer>)computerRepo.findAll();
    }

    @Override
    public Computer updateComputerById(Integer computerId, Computer computer) throws ComputerException {
        Optional<Computer> computerOptional = computerRepo.findById(computerId);

        if(computerOptional.isEmpty()){
            throw new ComputerException("Computer does not exist, cannot update");
        }

        Computer savedComputer = computerOptional.get();

        savedComputer.setAssetTag(computer.getAssetTag());
        savedComputer.setSerialNumber(computer.getSerialNumber());
        savedComputer.setStatus(computer.getStatus());
        savedComputer.setOwner(computer.getOwner());
        savedComputer.setBrand(computer.getBrand());
        savedComputer.setModel(computer.getModel());
        savedComputer.setType(computer.getType());
        savedComputer.setType(computer.getType());
        savedComputer.setColor(computer.getColor());
        savedComputer.setIssuedTo(computer.getIssuedTo());
        savedComputer.setGrantType(computer.getGrantType());
        savedComputer.setLoaned(computer.getLoaned());
        savedComputer.setLoans(computer.getLoans());
        savedComputer.setMaintenances(computer.getMaintenances());

        return computerRepo.save(savedComputer);
    }

    @Override
    public Boolean deleteComputerById(Integer computerId) throws ComputerException {
        Optional<Computer> computerOptional = computerRepo.findById(computerId);
        if(computerOptional.isEmpty()){
            throw new ComputerException("Computer does not exist, cannot delete");
        }

        Computer computerToDelete = computerOptional.get();
        computerRepo.delete(computerToDelete);
        return true;
    }
}
