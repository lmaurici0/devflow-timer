package br.com.ericluis.devflow_timer.controller;

import br.com.ericluis.devflow_timer.domain.FocusSession;
import br.com.ericluis.devflow_timer.service.FocusSessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Focus Sessions", description = "Gerenciamento de sessões de foco")
@RestController
@RequestMapping("/sessions")
public class FocusSessionController {

    private final FocusSessionService service;

    public FocusSessionController(FocusSessionService service) {
        this.service = service;
    }

    @Operation(summary = "Inicia uma sessão de estudos.")
    @PostMapping("/start")
    public ResponseEntity<FocusSession> start() {
        return ResponseEntity.ok(service.startSession());
    }

    @Operation(summary = "Finaliza uma sessão de estudos.")
    @PostMapping("/end")
    public ResponseEntity<FocusSession> end() {
        return ResponseEntity.ok(service.endSession());
    }

    @Operation(summary = "Retorna a quantidade de horas estudando e o nível de foco do aluno.")
    @GetMapping("/stats/today")
    public ResponseEntity<?> todayStats() {
        return ResponseEntity.ok(service.getTodayStats());
    }

}
