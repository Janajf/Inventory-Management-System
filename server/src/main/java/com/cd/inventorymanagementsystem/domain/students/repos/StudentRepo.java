package com.cd.inventorymanagementsystem.domain.students.repos;

import com.cd.inventorymanagementsystem.domain.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
