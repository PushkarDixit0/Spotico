package com.sportico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportico.pojos.CoachingSession;

public interface CoachingSessionDao extends JpaRepository<CoachingSession, Long> {

}
