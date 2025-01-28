package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.CoachingSession;

public interface CoachingSessionDao extends JpaRepository<CoachingSession, Long> {

}
