package com.cd.inventorymanagementsystem.domain.maintenance.repos;

import com.cd.inventorymanagementsystem.domain.maintenance.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepo extends JpaRepository<Maintenance, Integer> {
}
