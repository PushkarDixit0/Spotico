package com.spotico.pojos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournaments")
public class Tournaments extends BasicEntity {

	@Column(name="name ")
	private String TournamentName;
	@Column(name="description")
	private String TournamentDescription;
	@Column(name="venue")
	private String TournamentVenue;
	@Column(name="sportid")
	private Long Sport_ID;
	@Column(name="date")
	private LocalDateTime TournamentDate;
	
	
	
	public Tournaments() {
	
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
		return "Tournaments [TournamentName=" + TournamentName + ", TournamentDescription=" + TournamentDescription
				+ ", TournamentVenue=" + TournamentVenue + ", Sport_ID=" + Sport_ID + ", TournamentDate="
				+ TournamentDate + "]";
	}
	
	
	
	
}
