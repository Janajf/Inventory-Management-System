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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    @Lob
    @Column(nullable = true)
    private byte[] profilePicture;
    @Column(nullable = true, length = 20)
    private String profilePictureType;

    public User(String firstName, String lastName, String email, String password, Role role, byte[] profilePicture, String profilePictureType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
        this.profilePictureType = profilePictureType;
    }

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
