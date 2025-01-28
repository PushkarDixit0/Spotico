package com.spotico.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coachfeedback")
public class CoachFeedback extends BasicEntity {

	@Column(name = "user_id")
private Long User_ID;
	@Column(name = "coach_id")
private Long Coach_ID;
	@Column(name = "message")
private Long Message;
	@Column(name = "date")
private LocalDate Date;
	public CoachFeedback() {
	}
	public Long getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(Long user_ID) {
		User_ID = user_ID;
	}
	public Long getCoach_ID() {
		return Coach_ID;
	}
	public void setCoach_ID(Long coach_ID) {
		Coach_ID = coach_ID;
	}
	public Long getMessage() {
		return Message;
	}
	public void setMessage(Long message) {
		Message = message;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	@Override
	public String toString() {
		return "CoachFeedback [User_ID=" + User_ID + ", Coach_ID=" + Coach_ID + ", Message=" + Message + ", Date="
				+ Date + "]";
	}
	
	
}
