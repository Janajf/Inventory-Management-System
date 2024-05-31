package com.cd.inventorymanagementsystem.domain.loan.models;


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

    @Column(name= "computer_id")
    private Integer computerId;

    private Date startDate;
    private Date endDate;
}
