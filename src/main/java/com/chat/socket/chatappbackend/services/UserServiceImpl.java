package com.chat.socket.chatappbackend.services;

import com.chat.socket.chatappbackend.exceptions.UniqueConstrainException;
import com.chat.socket.chatappbackend.models.dto.UserCreationDTO;
import com.chat.socket.chatappbackend.models.dto.UserResponseDTO;
import com.chat.socket.chatappbackend.models.entity.User;
import com.chat.socket.chatappbackend.models.projections.UserResponse;
import com.chat.socket.chatappbackend.models.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;



    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> getAllUsersByPagination(Pageable pageable) {
        return userRepository.findAllBy(pageable);
    }

    @Override
    @Transactional()
    public UserResponseDTO registerUser(UserCreationDTO userCreationDTO) {

        if(userRepository.existsByUsername(userCreationDTO.getUsername()))
            throw new UniqueConstrainException("The username has already been registered");

        if(userRepository.existsByEmail(userCreationDTO.getEmail()))
            throw new UniqueConstrainException("The email has already been registered");

        User user = new User();
        user.setUsername(userCreationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userCreationDTO.getPassword()));
        user.setEmail(userCreationDTO.getEmail());
        user.setIsActive(false);
        user.setCreateAt(LocalDateTime.now());
        return convertToUserResponseDTO(userRepository.save(user));
    }


    private UserResponseDTO convertToUserResponseDTO(User user){
        UserResponseDTO userResponse = new UserResponseDTO();

        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setIsActive(user.getIsActive());
        userResponse.setCreateAt(user.getCreateAt());

        return userResponse;
    }

}
