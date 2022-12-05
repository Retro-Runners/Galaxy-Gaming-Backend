package com.revature.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor

@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "pass_word")
    @NotNull
    private String password;

    @OneToOne
    private Product[] cart;

    @OneToOne
    private Product[] wishlist;


    public User(int userId, String firstName, String lastName, String address, String email, String password) {
    }
}
