package com.chat.socket.chatappbackend.controllers;

import com.chat.socket.chatappbackend.models.dto.UserCreationDTO;
import com.chat.socket.chatappbackend.models.dto.UserResponseDTO;
import com.chat.socket.chatappbackend.models.projections.UserResponse;
import com.chat.socket.chatappbackend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public ResponseEntity<Page<UserResponse>> getAllUserByPagination(
            @RequestParam(name = "size",defaultValue = "10") int size,
            @RequestParam(name = "page",defaultValue = "0") int page){
        return new ResponseEntity<>(userService.getAllUsersByPagination(PageRequest.of(page,size)),HttpStatus.OK);
    }
}
