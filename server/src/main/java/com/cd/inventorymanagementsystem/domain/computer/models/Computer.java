package com.cd.inventorymanagementsystem.domain.computer.models;

import com.cd.inventorymanagementsystem.domain.item.Item;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="computers")
public class Computer extends Item {
    private String assetTag;
    private String serialNumber;
    private String status;
    private String owner;
    private String brand;
    private String model;
    private String type;
    private String color;
    private String issuedTo;
    private String grantType;
    private Boolean loaned;
    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Maintenance> maintenances = new ArrayList<>();

    private String chargedUpdated;


}
