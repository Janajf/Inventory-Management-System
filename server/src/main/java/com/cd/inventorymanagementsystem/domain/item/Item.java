package com.cd.inventorymanagementsystem.domain.item;

import com.cd.inventorymanagementsystem.domain.loan.models.Loan;
import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Date purchaseDate;
    private String grantIssuer;
    private Integer quantity;
    private Double price;

}
