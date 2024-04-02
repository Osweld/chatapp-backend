package com.chat.socket.chatappbackend.models.entity;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",nullable = false,length = 15)
    private String username;
    @Column(name = "password",nullable = false,length = 60)
    private String password;
    @Column(name = "email",nullable = false,length = 50)
    private String email;
    @Column(name = "is_active",nullable = false)
    private Boolean isActive;

}
