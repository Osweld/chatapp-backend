package com.chat.socket.chatappbackend.services;

import com.chat.socket.chatappbackend.models.dto.UserCreationDTO;
import com.chat.socket.chatappbackend.models.dto.UserResponseDTO;
import com.chat.socket.chatappbackend.models.projections.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserResponse> getAllUsersByPagination(Pageable pageable);

    UserResponseDTO registerUser(UserCreationDTO userCreationDTO);
}
