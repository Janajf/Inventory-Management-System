package com.cd.inventorymanagementsystem.domain.computer.controllers;

import com.cd.inventorymanagementsystem.domain.computer.exceptions.ComputerException;
import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.computer.services.ComputerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computers")
public class ComputerController {
    private final Logger logger = LoggerFactory.getLogger(ComputerController.class);
    private ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping("")
    public ResponseEntity<Computer> createComputer(@RequestBody Computer computer){
        Computer savedComputer = computerService.createComputer(computer);
        return new ResponseEntity<>(savedComputer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getComputerById(@PathVariable Integer id){
        try{
            Computer computer = computerService.getComputerById(id);
            ResponseEntity<?> response = new ResponseEntity<>(computer, HttpStatus.OK);
            return response;

        }catch(ComputerException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Computer>> getAllComputers(){
        List<Computer> computers = computerService.getAllComputers();
        ResponseEntity<List<Computer>> response = new ResponseEntity<>(computers, HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComputer(@PathVariable Integer id, @RequestBody Computer computer){
        try{
            Computer updatedComputer = computerService.updateComputerById(id,computer);
            ResponseEntity response = new ResponseEntity<>(updatedComputer, HttpStatus.OK);
            return response;

        } catch(ComputerException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedComputer(@PathVariable Integer id){
        try{
            computerService.deleteComputerById(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();

        }catch(ComputerException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }


}
