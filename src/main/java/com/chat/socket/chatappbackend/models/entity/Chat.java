package com.chat.socket.chatappbackend.models.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "chats")
public class Chat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat")
    private Long id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "update_at")
    private LocalDate updateAt;
}
