package com.cd.inventorymanagementsystem.domain.user.services;

import com.cd.inventorymanagementsystem.domain.user.exceptions.UserException;
import com.cd.inventorymanagementsystem.domain.user.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Integer userId) throws UserException;
    User getByEmail(String userEmail) throws UserException;
    List<User> getAllUsers();
    User updateUserById(Integer userId, User user) throws UserException;

    Boolean deleteUserById(Integer userId) throws UserException;

}
