package com.estudo.TelaLogin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    //CONSTRUTORES
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // GETTERS
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //TO STRING
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}