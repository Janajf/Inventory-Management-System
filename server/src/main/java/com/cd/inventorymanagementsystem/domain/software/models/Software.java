package com.cd.inventorymanagementsystem.domain.software.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Software {
    @Id
    @GeneratedValue
    private Integer id;
}
