package com.cd.inventorymanagementsystem.domain.user.controllers;

import com.cd.inventorymanagementsystem.domain.user.exceptions.UserException;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import com.cd.inventorymanagementsystem.domain.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        try{
            User user = userService.getUserById(id);
            ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
            return response;

        }catch(UserException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try{
            User user = userService.getByEmail(email);
            ResponseEntity<?> response = new ResponseEntity<>(user, HttpStatus.OK);
            return response;
        } catch (UserException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        ResponseEntity<List<User>> response = new ResponseEntity<>(users, HttpStatus.OK);
        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        try{
            User updatedUser = userService.updateUserById(id, user);
            ResponseEntity response = new ResponseEntity<>(updatedUser, HttpStatus.OK);
            return response;

        } catch(UserException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        try{
            userService.deleteUserById(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch(UserException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }



}
