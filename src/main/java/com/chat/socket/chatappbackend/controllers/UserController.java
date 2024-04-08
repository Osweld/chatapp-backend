package com.chat.socket.chatappbackend.controllers;

import com.chat.socket.chatappbackend.models.dto.UserCreationDTO;
import com.chat.socket.chatappbackend.models.dto.UserResponseDTO;
import com.chat.socket.chatappbackend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @Operation(summary = "Register user")
    public ResponseEntity<UserResponseDTO> userRegistration(@Valid @RequestBody UserCreationDTO userCreationDTO){
       return new ResponseEntity<>(userService.registerUser(userCreationDTO), HttpStatus.CREATED);
    }
}
