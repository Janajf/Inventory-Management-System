package com.cd.inventorymanagementsystem.domain.loan.models;

import com.cd.inventorymanagementsystem.domain.computer.models.Computer;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="item_id")
    private Computer computer;
    private Date startDate;
    private Date endDate;
}
