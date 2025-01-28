package com.spotico.DTO;

import java.time.LocalDateTime;

public class Tournamentsdto {
	private String TournamentName;
	
	private String TournamentDescription;
	
	private String TournamentVenue;
	
	private Long Sport_ID;
	
	private LocalDateTime TournamentDate;

	public Tournamentsdto() {
		
	}

	public String getTournamentName() {
		return TournamentName;
	}

	public void setTournamentName(String tournamentName) {
		TournamentName = tournamentName;
	}

	public String getTournamentDescription() {
		return TournamentDescription;
	}

	public void setTournamentDescription(String tournamentDescription) {
		TournamentDescription = tournamentDescription;
	}

	public String getTournamentVenue() {
		return TournamentVenue;
	}

	public void setTournamentVenue(String tournamentVenue) {
		TournamentVenue = tournamentVenue;
	}

	public Long getSport_ID() {
		return Sport_ID;
	}

	public void setSport_ID(Long sport_ID) {
		Sport_ID = sport_ID;
	}

	public LocalDateTime getTournamentDate() {
		return TournamentDate;
	}

	public void setTournamentDate(LocalDateTime tournamentDate) {
		TournamentDate = tournamentDate;
	}

	@Override
	public String toString() {
		return "Tournamentsdto [TournamentName=" + TournamentName + ", TournamentDescription=" + TournamentDescription
				+ ", TournamentVenue=" + TournamentVenue + ", Sport_ID=" + Sport_ID + ", TournamentDate="
				+ TournamentDate + "]";
	}
	
	
}
