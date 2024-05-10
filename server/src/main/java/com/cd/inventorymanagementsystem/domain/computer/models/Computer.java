package com.cd.inventorymanagementsystem.domain.computer.models;

import com.cd.inventorymanagementsystem.domain.item.models.Item;
import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import jakarta.persistence.*;
import lombok.*;

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
    @Id
    @GeneratedValue
    @Column(name="computer_id")
    private Integer id;

    @Column(name= "user_id")
    private Integer userId;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id")
    private List<Loan> loans;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "computer_id")
    private List<Maintenance> maintenances;



}
