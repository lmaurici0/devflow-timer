package br.com.ericluis.devflow_timer.service;

import br.com.ericluis.devflow_timer.domain.FocusSession;
import br.com.ericluis.devflow_timer.dto.TodayStatsResponse;
import br.com.ericluis.devflow_timer.repository.FocusSessionRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FocusSessionService {

    private final FocusSessionRepository repository;

    public FocusSessionService(FocusSessionRepository repository) {
        this.repository = repository;
    }

    public FocusSession startSession() {
        repository.findFirstByEndTimeIsNull()
                .ifPresent(s -> {
                    throw new IllegalStateException("There is already an active focus session");
                });

        FocusSession session = new FocusSession();
        session.setStartTime(LocalDateTime.now());

        return repository.save(session);
    }

    public FocusSession endSession() {
        FocusSession session = repository.findFirstByEndTimeIsNull()
                .orElseThrow(() -> new IllegalStateException("No active focus session found"));

        session.setEndTime(LocalDateTime.now());

        long minutes = Duration.between(session.getStartTime(), session.getEndTime()).toMinutes();

        if (minutes < 15) {
            session.setValid(false);
            session.setDurationMinutes((int) minutes);
        } else {
            session.setValid(true);
            session.setDurationMinutes((int) Math.min(minutes, 120));
        }

        return repository.save(session);
    }

    public TodayStatsResponse getTodayStats() {
        List<FocusSession> sessions = repository.findByValidTrue();

        int totalMinutes = sessions.stream()
                .mapToInt(FocusSession::getDurationMinutes)
                .sum();

        String classification;

        if (totalMinutes < 60) {
            classification = "FOCO_BAIXO";
        } else if (totalMinutes <= 120) {
            classification = "FOCO_MEDIO";
        } else {
            classification = "FOCO_ALTO";
        }

        return new TodayStatsResponse(
                totalMinutes,
                sessions.size(),
                classification
        );
    }

}
