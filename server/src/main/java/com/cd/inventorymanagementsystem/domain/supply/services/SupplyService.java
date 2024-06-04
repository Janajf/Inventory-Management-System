package com.cd.inventorymanagementsystem.domain.supply.services;


import com.cd.inventorymanagementsystem.domain.supply.exceptions.SupplyException;
import com.cd.inventorymanagementsystem.domain.supply.models.Supply;

import java.util.List;

public interface SupplyService {
    Supply create(Supply supply);
    Supply getById(Integer id) throws SupplyException;
    List<Supply> getAll();
    Supply update(Integer id, Supply supplyDetail) throws SupplyException;;
    Boolean delete(Integer id) throws SupplyException;;
}
