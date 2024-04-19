package com.cd.inventorymanagementsystem.domain.item.models;

import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date purchaseDate;
    private String grantIssuer;
    private String assetNumber;
    private String serialNumber;
    private String storageLocation;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Loan> loans;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "item_id")
    private List<Maintenance> maintenances;



}
