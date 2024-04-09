package com.chat.socket.chatappbackend.models.repository;


import com.chat.socket.chatappbackend.models.entity.User;
import com.chat.socket.chatappbackend.models.projections.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Page<UserResponse> findAllBy(Pageable pageable);
}
