package org.example.repository;

import org.example.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    boolean existsBySessionId(String sessionId);
    Session findBySessionId(String sessionId);
}