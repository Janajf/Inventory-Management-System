package com.cd.inventorymanagementsystem.domain.user.models;

import com.cd.inventorymanagementsystem.domain.item.models.Item;
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
    private Integer id;
    private String uid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean admin;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Item> items;

    public User(String uid, String firstName, String lastName, String email, String password, Boolean admin) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
}
