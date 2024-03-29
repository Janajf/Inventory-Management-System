package com.cd.inventorymanagementsystem.domain.user.services;

import com.cd.inventorymanagementsystem.domain.user.exceptions.UserException;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import com.cd.inventorymanagementsystem.domain.user.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public User getUserById(Integer userId) throws UserException {
        Optional<User> userOptional= userRepo.findById(userId);

        if(userOptional.isEmpty()){
            logger.error("User with {} does not exist", userId);
            throw new UserException("User not found");
        }
        return userOptional.get();
    }

    @Override
    public User getByEmail(String userEmail) throws UserException {
        Optional<User> userOptional = userRepo.findByEmail(userEmail);
        if(userOptional.isEmpty()){
            logger.error("User with {} does not exist", userEmail);
            throw new UserException("User not found");
        }

        return userOptional.get();
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepo.findAll();
    }

    @Override
    public User updateUserById(Integer userId, User user) throws UserException {
        Optional<User> userOptional = userRepo.findById(userId);

        if(userOptional.isEmpty()){
            throw new UserException("User does not exists, cannot update");
        }

        User savedUser = userOptional.get();

        savedUser.setUid(user.getUid());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());
        savedUser.setAdmin(user.getAdmin());
        savedUser.setItems(user.getItems());

        return userRepo.save(savedUser);
    }

    @Override
    public Boolean deleteUserById(Integer userId) throws UserException {
        Optional<User> userOptional = userRepo.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserException("User does not exist, cannot delete");
        }

        User userToDelete = userOptional.get();
        userRepo.delete(userToDelete);
        return true;
    }
}
