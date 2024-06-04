package com.cd.inventorymanagementsystem.domain.maintenance.controllers;

import com.cd.inventorymanagementsystem.domain.computer.controllers.ComputerController;
import com.cd.inventorymanagementsystem.domain.computer.exceptions.ComputerException;
import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.maintenance.exceptions.MaintenanceException;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.cd.inventorymanagementsystem.domain.maintenance.services.MaintenanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/maintenances")
public class MaintenanceController {
    private final Logger logger = LoggerFactory.getLogger(MaintenanceController.class);
    private MaintenanceService maintenanceService;
    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("")
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance maintenance){
        Maintenance savedMaintenance = maintenanceService.create(maintenance);
        return new ResponseEntity<>(savedMaintenance, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Maintenance maintenance = maintenanceService.getById(id);
            ResponseEntity<?> response = new ResponseEntity<>(maintenance, HttpStatus.OK);
            return response;

        }catch(MaintenanceException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Maintenance>> getAll(){
        List<Maintenance> maintenances = maintenanceService.getAll();
        ResponseEntity<List<Maintenance>> response = new ResponseEntity<>(maintenances, HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Maintenance maintenance){
        try{
            Maintenance updatedMaintenance = maintenanceService.update(id,maintenance);
            ResponseEntity response = new ResponseEntity<>(updatedMaintenance, HttpStatus.OK);
            return response;

        } catch(MaintenanceException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleted(@PathVariable Integer id){
        try{
            maintenanceService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();

        }catch(MaintenanceException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
