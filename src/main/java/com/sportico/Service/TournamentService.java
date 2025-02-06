package com.sportico.Service;

import java.util.List;

import com.sportico.DTO.TournamentDTO;

public interface TournamentService{

	List<TournamentDTO> getAllTournaments();

	TournamentDTO addTournament(TournamentDTO t);

	String deleteTournament(Long id);

	TournamentDTO updateTournament(Long id, TournamentDTO t);

	TournamentDTO getTournamentById(Long id);

}
