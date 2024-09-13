package german.dev.chatappbackend.controller;

import german.dev.chatappbackend.model.entity.Status;
import german.dev.chatappbackend.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    ResponseEntity<List<Status>> getAllStatuses() {
        return ResponseEntity.ok(statusService.getAllStatuses());
    }
}
