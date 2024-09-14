package german.dev.chatappbackend.controller;

import german.dev.chatappbackend.model.projection.UserProjection;
import german.dev.chatappbackend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{idUser}")
    ResponseEntity<UserProjection> getUserById(@PathVariable Long idUser) {
        return ResponseEntity.ok(userService.findById(idUser));
    }

    @GetMapping("/username/{username}")
    ResponseEntity<UserProjection> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/search/{username}")
    ResponseEntity<List<UserProjection>> searchUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.searchUserByUsername(username));
    }

    @GetMapping()
    ResponseEntity<Page<UserProjection>> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return ResponseEntity.ok(userService.findAllUsers(page, size));
    }




}
