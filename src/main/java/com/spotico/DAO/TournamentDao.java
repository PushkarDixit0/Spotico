package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.Tournaments;

public interface TournamentDao extends JpaRepository<Tournaments, Long> {

}
