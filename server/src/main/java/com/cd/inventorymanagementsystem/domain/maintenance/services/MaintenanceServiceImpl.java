package com.cd.inventorymanagementsystem.domain.maintenance.services;

import com.cd.inventorymanagementsystem.domain.maintenance.exceptions.MaintenanceException;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.cd.inventorymanagementsystem.domain.maintenance.repos.MaintenanceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{
    private static Logger logger = LoggerFactory.getLogger(MaintenanceServiceImpl.class);
    private MaintenanceRepo maintenanceRepo;
    @Autowired
    public MaintenanceServiceImpl(MaintenanceRepo maintenanceRepo) {
        this.maintenanceRepo = maintenanceRepo;
    }
    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public Maintenance getById(Integer id) throws MaintenanceException {
        Optional<Maintenance> optionalMaintenance = maintenanceRepo.findById(id);
        if(optionalMaintenance.isEmpty()){
            logger.error("Computer with {} does not exist", id);
            throw new MaintenanceException("Maintenance not found");
        }
        return optionalMaintenance.get();
    }

    @Override
    public List<Maintenance> getAll() {
        return (List<Maintenance>)maintenanceRepo.findAll();
    }

    @Override
    public Maintenance update(Integer id, Maintenance maintenance) throws MaintenanceException {
        Optional<Maintenance> optionalMaintenance = maintenanceRepo.findById(id);

        if(optionalMaintenance.isEmpty()){
            throw new MaintenanceException("Maintenance does not exist, cannot update");
        }

        Maintenance savedMaintenance = optionalMaintenance.get();

        savedMaintenance .setComputer(maintenance.getComputer());
        savedMaintenance.setDate(maintenance.getDate());
        savedMaintenance.setDescription(maintenance.getDescription());


        return maintenanceRepo.save(savedMaintenance);
    }

    @Override
    public Boolean delete(Integer id) throws MaintenanceException {
        Optional<Maintenance> optionalMaintenance = maintenanceRepo.findById(id);

        if(optionalMaintenance.isEmpty()){
            throw new MaintenanceException("Maintenance does not exist, cannot delete");
        }

        Maintenance maintenanceToDelete= optionalMaintenance.get();
        maintenanceRepo.delete(maintenanceToDelete);
        return true;
    }
}
