package com.cd.inventorymanagementsystem.domain.item;

import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
public abstract class Item {
    private Integer id;
    private String name;
    private String description;
    private Date purchaseDate;
    private String grantIssuer;
    private Integer quantity;
    private Double price;

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
