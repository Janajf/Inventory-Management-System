package com.cd.inventorymanagementsystem.domain.supply.models;

import com.cd.inventorymanagementsystem.domain.item.Item;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="supplies")
public class Supply extends Item {

    private String sku;
    private int quantityInStock;
    private String unit;
    private String buildingLocation;
    private String floor;
    private String lockerArea;
    private int reorderLevel;
    private int reorderQuantity;
    private int leadTimeForReorder;
    private String vendor;
    private double estimatedCost;
}
