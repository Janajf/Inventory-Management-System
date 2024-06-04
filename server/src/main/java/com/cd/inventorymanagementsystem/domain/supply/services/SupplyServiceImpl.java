package com.cd.inventorymanagementsystem.domain.supply.services;
import com.cd.inventorymanagementsystem.domain.supply.exceptions.SupplyException;
import com.cd.inventorymanagementsystem.domain.supply.models.Supply;
import com.cd.inventorymanagementsystem.domain.supply.repos.SupplyRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService {

    private static final Logger logger = LoggerFactory.getLogger(SupplyServiceImpl.class);
    private  SupplyRepo supplyRepo;

    @Autowired
    public SupplyServiceImpl(SupplyRepo supplyRepo) {
        this.supplyRepo = supplyRepo;
    }

    @Override
    public List<Supply> getAll() {
        return (List<Supply>) supplyRepo.findAll();
    }

    @Override
    public Supply getById(Integer id) throws SupplyException {
        Optional<Supply> optionalSupply = supplyRepo.findById(id);

        if (optionalSupply.isEmpty()) {
            logger.error("Supply with id {} does not exist", id);
            throw new SupplyException("Supply not found");
        }
        return optionalSupply.get();
    }

    @Override
    public Supply create(Supply supply) {
        return supplyRepo.save(supply);
    }

    @Override
    public Supply update(Integer id, Supply supply) throws SupplyException {
        Optional<Supply> optionalSupply = supplyRepo.findById(id);

        if (optionalSupply.isEmpty()) {
            throw new SupplyException("Supply does not exist, cannot update");
        }

        Supply existingSupply = optionalSupply.get();

        existingSupply.setSku(supply.getSku());
        existingSupply.setQuantityInStock(supply.getQuantityInStock());
        existingSupply.setUnit(supply.getUnit());
        existingSupply.setBuildingLocation(supply.getBuildingLocation());
        existingSupply.setFloor(supply.getFloor());
        existingSupply.setLockerArea(supply.getLockerArea());
        existingSupply.setReorderLevel(supply.getReorderLevel());
        existingSupply.setReorderQuantity(supply.getReorderQuantity());
        existingSupply.setLeadTimeForReorder(supply.getLeadTimeForReorder());
        existingSupply.setVendor(supply.getVendor());
        existingSupply.setEstimatedCost(supply.getEstimatedCost());

        return supplyRepo.save(existingSupply);
    }

    @Override
    public Boolean delete(Integer id) throws SupplyException {
        Optional<Supply> optionalSupply = supplyRepo.findById(id);

        if (optionalSupply.isEmpty()) {
            logger.error("Supply with id {} does not exist", id);
            throw new SupplyException("Supply not found, cannot delete");
        }

        Supply supplyToDelete = optionalSupply.get();
        supplyRepo.delete(supplyToDelete);
        return true;
    }
}
