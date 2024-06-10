package com.cd.inventorymanagementsystem.domain.maintenance.models;


import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.software.models.Software;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="maintenances")
public class Maintenance {
    @Id
    @GeneratedValue
    @Column(name="maintenance_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    @JsonBackReference
    private Computer computer;

    private Date date;
    private String description;

}
