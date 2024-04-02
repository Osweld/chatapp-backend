package com.chat.socket.chatappbackend.models.repository;


import com.chat.socket.chatappbackend.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
