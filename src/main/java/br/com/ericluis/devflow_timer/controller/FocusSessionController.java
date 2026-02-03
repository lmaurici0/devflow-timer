package br.com.ericluis.devflow_timer.controller;

import br.com.ericluis.devflow_timer.domain.FocusSession;
import br.com.ericluis.devflow_timer.service.FocusSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessions")
public class FocusSessionController {

    private final FocusSessionService service;

    public FocusSessionController(FocusSessionService service) {
        this.service = service;
    }

    @PostMapping("/start")
    public ResponseEntity<FocusSession> start() {
        return ResponseEntity.ok(service.startSession());
    }

    @PostMapping("/end")
    public ResponseEntity<FocusSession> end() {
        return ResponseEntity.ok(service.endSession());
    }

    @GetMapping("/stats/today")
    public ResponseEntity<?> todayStats() {
        return ResponseEntity.ok(service.getTodayStats());
    }

}
