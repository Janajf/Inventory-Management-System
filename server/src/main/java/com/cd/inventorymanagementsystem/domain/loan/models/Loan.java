package com.cd.inventorymanagementsystem.domain.loan.models;


import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="loans")
public class Loan {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    @JsonBackReference
    private Computer computer;

    private Date startDate;
    private Date endDate;
}
