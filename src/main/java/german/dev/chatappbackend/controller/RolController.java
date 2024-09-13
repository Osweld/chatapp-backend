package german.dev.chatappbackend.controller;

import german.dev.chatappbackend.model.entity.Rol;
import german.dev.chatappbackend.service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    ResponseEntity<List<Rol>> getAllRoles() {
        return ResponseEntity.ok(rolService.getAllRoles());
    }
}
