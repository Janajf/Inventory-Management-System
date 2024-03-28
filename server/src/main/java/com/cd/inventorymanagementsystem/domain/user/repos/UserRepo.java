package com.cd.inventorymanagementsystem.domain.user.repos;

import com.cd.inventorymanagementsystem.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    <Optional> User findUserByEmail(String email);
}
