package com.sportico.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportico.DTO.TournamentDTO;
import com.sportico.Service.TournamentEnrollmentService;
import com.sportico.Service.TournamentService;
import com.sportico.pojos.User;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/enrollment")
public class TournamentEnrollmentController {

	@Autowired
	public TournamentEnrollmentService tournamentEnrollmentService;
	
	@Autowired
	public TournamentService tournamentService;
	
	@PostMapping("/{tournamentId}/{userId}")
    public ResponseEntity<?> enrollInTournament(@PathVariable Long tournamentId, @PathVariable Long userId) {
        try {
            TournamentDTO tdto = tournamentService.getTournamentById(tournamentId);
            if (tdto == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tournament not found.");
            }

            String enrolled = tournamentEnrollmentService.enrollUserInTournament(userId, tournamentId);
            return ResponseEntity.ok(enrolled);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error enrolling user in tournament.");
        }
    }

    // Get all tournaments
    @GetMapping
    public ResponseEntity<?> getAllTournaments() {
        try {
            List<TournamentDTO> tournaments = tournamentService.getAllTournaments();
            return ResponseEntity.status(HttpStatus.OK).body(tournaments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/enrollments/{userId}")
    public ResponseEntity<?> getEnrolledTournaments(@PathVariable Long userId) {
    	try {
            List<TournamentDTO> enrolled = tournamentEnrollmentService.getEnrolledTournament(userId);
            return ResponseEntity.status(HttpStatus.OK).body(enrolled);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    

}
