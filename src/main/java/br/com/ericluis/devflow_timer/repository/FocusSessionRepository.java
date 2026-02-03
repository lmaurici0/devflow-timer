package br.com.ericluis.devflow_timer.repository;

import br.com.ericluis.devflow_timer.domain.FocusSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FocusSessionRepository extends JpaRepository<FocusSession, Long> {

    Optional<FocusSession> findFirstByEndTimeIsNull();

    List<FocusSession> findByValidTrue();

}
