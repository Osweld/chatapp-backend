package com.chat.socket.chatappbackend.models.repository;

import com.chat.socket.chatappbackend.models.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Long> {
}
