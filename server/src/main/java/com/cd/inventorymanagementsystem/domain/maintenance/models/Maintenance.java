package com.cd.inventorymanagementsystem.domain.maintenance.models;

import com.cd.inventorymanagementsystem.domain.item.models.Item;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="item_id")
    private Item item;
    private Date date;
    private String description;
}
