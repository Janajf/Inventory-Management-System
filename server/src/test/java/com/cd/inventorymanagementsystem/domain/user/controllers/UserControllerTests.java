package com.cd.inventorymanagementsystem.domain.user.controllers;

import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import com.cd.inventorymanagementsystem.domain.user.exceptions.UserException;
import com.cd.inventorymanagementsystem.domain.user.models.Role;
import com.cd.inventorymanagementsystem.domain.user.models.User;
import com.cd.inventorymanagementsystem.domain.user.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class UserControllerTests {

    @MockBean
    UserService mockUserService;

    @Autowired
    private MockMvc mockMvc;

    private User inputUser;
    private User mockResponseUser;
    private String jsonInputUser;


    @BeforeEach
    public void setUp() throws JsonProcessingException {
        List<User> users = new ArrayList<>();
        List<Computer> computers = new ArrayList<>();

        inputUser = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.USER)
                .build();

        mockResponseUser = User.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .password("password")
                .role(Role.USER)
                .build();

        JsonMapper jsonMapper = new JsonMapper();
        jsonInputUser = jsonMapper.writeValueAsString(inputUser);
    }

    @Test
    @DisplayName("POST /user - Success")
    public void createUserTestSuccess()throws Exception{
        BDDMockito.doReturn(mockResponseUser).when(mockUserService).createUser(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInputUser))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Is.is("firstName")));
    }

    @Test
    @DisplayName("GET /user/1 - Success")
    public void getUserByIdTestSuccess() throws Exception{

        BDDMockito.doReturn(mockResponseUser).when(mockUserService).getUserById(1);

        mockMvc.perform(get("/api/v1/users/{id}", 1))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.firstName", Is.is("firstName")));
    }

    @Test
    @DisplayName("GET /user/1 - Fail")
    public void getUserByIdTestFail() throws Exception{
        BDDMockito.doThrow(new UserException("User not found")).when(mockUserService).getUserById(1);

        mockMvc.perform(get("/api/v1/users/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("GET /user/email - Success")
    public void getUserByEmailTestSuccess() throws Exception{

        BDDMockito.doReturn(mockResponseUser).when(mockUserService).getByEmail("email");

        mockMvc.perform(get("/api/v1/users/email/{email}", "email"))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.firstName", Is.is("firstName")));
    }

    @Test
    @DisplayName("GET /user/email - Fail")
    public void getUserByEmailTestFail() throws Exception{
        BDDMockito.doThrow(new UserException("User not found")).when(mockUserService).getByEmail("email");

        mockMvc.perform(get("/api/v1/users/email/{email}", "email"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /user/1 - Success")
    public void updateUserTestSuccess() throws Exception{

        List<Computer> computers = new ArrayList<>();
        User updatedUser = User.builder()
                .id(1)
                .firstName("firstName")
                .lastName("lastName")
                .email("updatedEmail")
                .password("password")
                .role(Role.USER)
                .build();

        BDDMockito.doReturn(updatedUser).when(mockUserService).updateUserById(any(), any());

        mockMvc.perform(put("/api/v1/users/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonInputUser))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Is.is(1)))
                .andExpect(jsonPath("$.email", Is.is("updatedEmail")));
    }

    @Test
    @DisplayName("PUT /user/1 - Fail")
    public void updateUserTestFail() throws Exception{
        BDDMockito.doThrow(new UserException("User not found")).when(mockUserService).updateUserById(any(), any());

        mockMvc.perform(put("/api/v1/users/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonInputUser))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /user/1 - Success")
    public void deleteUserTestSuccess() throws Exception{
        BDDMockito.doReturn(true).when(mockUserService).deleteUserById(any());
        mockMvc.perform(delete("/api/v1/users/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE /user/1 - Success")
    public void deleteUserTestFail() throws Exception{
        BDDMockito.doThrow(new UserException("User not found")).when(mockUserService).deleteUserById(any());
        mockMvc.perform(delete("/api/v1/users/{id}", 1))
                .andExpect(status().isNotFound());
    }





}
