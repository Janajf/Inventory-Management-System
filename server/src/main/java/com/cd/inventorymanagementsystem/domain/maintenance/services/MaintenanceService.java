package com.cd.inventorymanagementsystem.domain.maintenance.services;

import com.cd.inventorymanagementsystem.domain.maintenance.exceptions.MaintenanceException;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;

import java.util.List;

public interface MaintenanceService {
    Maintenance create(Maintenance maintenance);
    Maintenance getById(Integer id) throws MaintenanceException;
    List<Maintenance> getAll();
    Maintenance update(Integer id, Maintenance maintenanceDetail) throws MaintenanceException;
    Boolean delete(Integer id) throws MaintenanceException;
}
