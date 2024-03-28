package com.cd.inventorymanagementsystem.domain.user.services;

import com.cd.inventorymanagementsystem.domain.user.exceptions.UserException;
import com.cd.inventorymanagementsystem.domain.user.models.Role;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import com.cd.inventorymanagementsystem.domain.user.repos.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceImplTests {
    @MockBean
    private UserRepo mockUserRepo;
    @Autowired
    private UserService userService;

    private User inputUser;
    private User mockResponseUser;

    @BeforeEach
    public void setUp(){
        List<User> users = new ArrayList<>();

        inputUser = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.ADMIN)
                .build();

        mockResponseUser = User.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.ADMIN)
                .build();

    }

    @Test
    @DisplayName("User Service: Create User Success")
    public void createUserTestSuccess(){
        BDDMockito.doReturn(mockResponseUser).when(mockUserRepo).save(ArgumentMatchers.any());
        User returnedUser = userService.createUser(inputUser);
        Assertions.assertNotNull(returnedUser, "User should not be null");
        Assertions.assertEquals(returnedUser.getId(), 1);
    }

    @Test
    @DisplayName("User Service: Get User By ID - Success")
    public void getUserByIdTestSuccess() throws UserException {
        BDDMockito.doReturn(Optional.of(mockResponseUser)).when(mockUserRepo).findById(1);
        User foundUser = userService.getUserById(1);
        Assertions.assertEquals(foundUser.toString(), mockResponseUser.toString());
    }

    @Test
    @DisplayName("User Service: Get User By ID - Fail")
    public void getUserByIdTestFail() throws UserException {
        BDDMockito.doReturn(Optional.empty()).when(mockUserRepo).findById(1);
        Assertions.assertThrows(UserException.class, () -> {
            userService.getUserById(1);
        });
    }

    @Test
    @DisplayName("User Service: Get All Users - Success")
    public void getAllUsersTestSuccess(){
        List<User> users = new ArrayList<>();
        users.add(mockResponseUser);
        BDDMockito.doReturn(users).when(mockUserRepo).findAll();
        List<User> returnedUsers = userService.getAllUsers();
        Assertions.assertIterableEquals(users, returnedUsers);
    }

    @Test
    @DisplayName("User Service: Update User - Success")
    public void updateUserTestSuccess() throws UserException{

        User expectedUserUpdate = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.ADMIN)
                .build();

        BDDMockito.doReturn(Optional.of(mockResponseUser)).when(mockUserRepo).findById(1);
        BDDMockito.doReturn(expectedUserUpdate).when(mockUserRepo).save(ArgumentMatchers.any());
        User actualUser = userService.updateUserById(1, expectedUserUpdate);
        Assertions.assertEquals(expectedUserUpdate.toString(), actualUser.toString());
    }
    @Test
    @DisplayName("User Service: Update User - Fail")
    public void updateUserTestFail(){
        User expectedUserUpdate = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.ADMIN)
                .build();

        BDDMockito.doReturn(Optional.empty()).when(mockUserRepo).findById(1);
        Assertions.assertThrows(UserException.class, () ->{
            userService.updateUserById(1,expectedUserUpdate);
        });
    }

    @Test
    @DisplayName("User Service: Delete User - Success")
    public void deleteUserTestSuccess() throws UserException{
        BDDMockito.doReturn(Optional.of(mockResponseUser)).when(mockUserRepo).findById(1);
        Boolean actualResponse = userService.deleteUserById(1);
        Assertions.assertTrue(actualResponse);
    }

    @Test
    @DisplayName("User Service: Delete User - Fail")
    public void deleteUserTestFail(){
        BDDMockito.doReturn(Optional.empty()).when(mockUserRepo).findById(1);
        Assertions.assertThrows(UserException.class, () ->{
            userService.deleteUserById(1);
        });
    }




}
