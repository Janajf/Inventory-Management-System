package com.cd.inventorymanagementsystem.domain.item.repos;

import com.cd.inventorymanagementsystem.domain.item.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);

}
