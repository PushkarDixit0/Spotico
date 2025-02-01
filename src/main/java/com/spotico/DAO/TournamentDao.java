package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.Tournament;

public interface TournamentDao extends JpaRepository<Tournament, Long> {

}
