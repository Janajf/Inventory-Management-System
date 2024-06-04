package com.cd.inventorymanagementsystem.domain.supply.repos;

import com.cd.inventorymanagementsystem.domain.supply.models.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepo extends JpaRepository<Supply, Integer> {
}
