package com.spotico.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotico.DAO.SportsDao;
import com.spotico.DAO.TournamentDao;
import com.spotico.DTO.TournamentDTO;
import com.spotico.pojos.Sport;
import com.spotico.pojos.Tournament;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService{
	@Autowired
	public TournamentDao tournamentDao;
	
	@Autowired
	public SportsDao sportsDao;
	
	@Autowired
	public ModelMapper modelMapper;
	
	@Override
	public List<TournamentDTO> getAllTournaments() {
	    List<Tournament> tournaments = tournamentDao.findAll();
	    
	    return tournaments.stream()
	            .map(tournament -> {
	             TournamentDTO tdto = 	modelMapper.map(tournament, TournamentDTO.class);
	            	if(tournament.getSport()!=null)
	            		tdto.setSportName(tournament.getSport().getName());
	            	
	            return tdto;
	            })
	            .collect(Collectors.toList());
	}

	
	@Override
	public TournamentDTO addTournament(TournamentDTO t) {
		Sport sport = sportsDao.findByName(t.getSportName()).orElseThrow();
		 
		Tournament tournament = modelMapper.map(t, Tournament.class);
		
		tournament.setSport(sport);
		
		 Tournament savedTournament = tournamentDao.save(tournament);
		 
		 return modelMapper.map(savedTournament, TournamentDTO.class);
	}

	@Override
	public TournamentDTO updateTournament(Long id, TournamentDTO t) {
			Tournament tournament =  tournamentDao.findById(id).orElseThrow();
			
			Sport sport = sportsDao.findByName(t.getSportName()).orElseThrow();

			        modelMapper.map(t, tournament);

				    tournament.setSport(sport);

				    Tournament savedTournament = tournamentDao.save(tournament);

				    TournamentDTO responseDTO = modelMapper.map(savedTournament, TournamentDTO.class);
				    responseDTO.setSportName(savedTournament.getSport().getName()); 
				    return responseDTO;
	}

	@Override
	public String deleteTournament(Long id) {
		if(tournamentDao.existsById(id)) {
			 tournamentDao.deleteById(id);
			return "Tournament deleted";
		}
		else
			throw new EntityNotFoundException("Tournament not found!!");
		
	}
	
	@Override
	public TournamentDTO getTournamentById(Long id) {
	    Tournament tournament = tournamentDao.findById(id)
	            .orElseThrow();

	    TournamentDTO responseDTO = modelMapper.map(tournament, TournamentDTO.class);
	    responseDTO.setSportName(tournament.getSport().getName()); 
	    return responseDTO;
	}

}
