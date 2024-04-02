package com.chat.socket.chatappbackend.models.repository;

import com.chat.socket.chatappbackend.models.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
