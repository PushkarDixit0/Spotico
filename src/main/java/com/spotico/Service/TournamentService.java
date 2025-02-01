package com.spotico.Service;

import java.util.List;

import com.spotico.DTO.TournamentDTO;

public interface TournamentService{

	List<TournamentDTO> getAllTournaments();

	TournamentDTO addTournament(TournamentDTO t);

	String deleteTournament(Long id);

	TournamentDTO updateTournament(Long id, TournamentDTO t);

	TournamentDTO getTournamentById(Long id);

}
