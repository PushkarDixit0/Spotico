package com.sportico.DTO;

public class CoachingSessiondto {
	
	private String Description;
	
	private String Venue;
	
	private String Duration;	
	
	private Long SportID;
	
	private Long Coach_ID;

	public CoachingSessiondto() {
		
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
		return "CoachingSessiondto [Description=" + Description + ", Venue=" + Venue + ", Duration=" + Duration
				+ ", SportID=" + SportID + ", Coach_ID=" + Coach_ID + "]";
	}
	
	
	
	
	
	
}
