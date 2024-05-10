package com.cd.inventorymanagementsystem.domain.software.repos;

import com.cd.inventorymanagementsystem.domain.software.models.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepo extends JpaRepository<Software, Integer> {
}
