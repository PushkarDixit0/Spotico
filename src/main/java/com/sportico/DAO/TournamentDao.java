package com.sportico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportico.pojos.Tournament;

public interface TournamentDao extends JpaRepository<Tournament, Long> {

}
