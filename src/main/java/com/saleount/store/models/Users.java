package com.saleount.store.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Users {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String username, email, password;

    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users() {
    }
}
