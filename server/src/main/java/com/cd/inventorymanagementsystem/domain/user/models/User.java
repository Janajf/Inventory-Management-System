package com.cd.inventorymanagementsystem.domain.user.models;

import com.cd.inventorymanagementsystem.domain.computer.models.Computer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Integer id;
    private String uid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean admin;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Computer> computers;


    public User(String uid, String firstName, String lastName, String email, String password, Boolean admin) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
}
