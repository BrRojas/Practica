package com.Practica.Practica.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;


    public User() {
    }

    public User(Long id, String name, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
    }
}
