package com.sportico.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coachingSession")

public class CoachingSession extends BasicEntity {

	@Column(name = "description")
	private String Description;
	@Column(name = "venue")
	private String Venue;
	@Column(name = "duration")
	private String Duration;	
	@Column(name = "sportId")
	private Long SportID;
	@Column(name = "coach_ID")
	private Long Coach_ID;
	public CoachingSession() {
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public Long getSportID() {
		return SportID;
	}
	public void setSportID(Long sportID) {
		SportID = sportID;
	}
	public Long getCoach_ID() {
		return Coach_ID;
	}
	public void setCoach_ID(Long coach_ID) {
		Coach_ID = coach_ID;
	}
	@Override
	public String toString() {
		return "CoachingSession [Description=" + Description + ", Venue=" + Venue + ", Duration=" + Duration
				+ ", SportID=" + SportID + ", Coach_ID=" + Coach_ID + "]";
	}
	
	
	
	
}
