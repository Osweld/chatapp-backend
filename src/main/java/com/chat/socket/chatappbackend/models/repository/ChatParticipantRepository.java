package com.chat.socket.chatappbackend.models.repository;

import com.chat.socket.chatappbackend.models.entity.ChatParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatParticipantRepository extends JpaRepository<ChatParticipant,Long> {
}
