package com.chat.socket.chatappbackend.models.projections;
import java.time.LocalDateTime;

public interface UserResponse {

    Long getId();
    String getUsername();
    String getEmail();
    Boolean getIsActive();
    LocalDateTime getCreateAt();
}
