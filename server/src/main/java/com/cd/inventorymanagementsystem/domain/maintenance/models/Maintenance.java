package com.cd.inventorymanagementsystem.domain.maintenance.models;


import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.software.models.Software;
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

    @Column(name= "computer_id")
    private Integer computerId;

    private Date date;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="maintenance_id")
    private List<Software> software;
}
