package com.cd.inventorymanagementsystem.domain.supply.controllers;

import com.cd.inventorymanagementsystem.domain.supply.exceptions.SupplyException;
import com.cd.inventorymanagementsystem.domain.supply.models.Supply;
import com.cd.inventorymanagementsystem.domain.supply.services.SupplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplies")
public class SupplyController {

    private final Logger logger = LoggerFactory.getLogger(SupplyController.class);
    private SupplyService supplyService;

    @Autowired
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping("")
    public ResponseEntity<Supply> createSupply(@RequestBody Supply supply) {
        Supply createdSupply = supplyService.create(supply);
        return new ResponseEntity<>(createdSupply, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplyById(@PathVariable Integer id) {
        try {
            Supply supply = supplyService.getById(id);
            return new ResponseEntity<>(supply, HttpStatus.OK);
        } catch (SupplyException e) {
            logger.error("Supply with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Supply>> getAllSupplies() {
        List<Supply> supplies = supplyService.getAll();
        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupply(@PathVariable Integer id, @RequestBody Supply supplyDetail) {
        try {
            Supply updatedSupply = supplyService.update(id, supplyDetail);
            return new ResponseEntity<>(updatedSupply, HttpStatus.OK);
        } catch (SupplyException e) {
            logger.error("Supply with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupply(@PathVariable Integer id) {
        try {
            supplyService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (SupplyException e) {
            logger.error("Supply with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
