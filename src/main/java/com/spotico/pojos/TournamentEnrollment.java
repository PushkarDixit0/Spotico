package com.spotico.pojos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "tournamentEnrollment")

public class TournamentEnrollment extends BasicEntity {

	@Column(name = "user_id")
	private Long User_ID;
	@Column(name = "tournament_id")
	private Long Tournament_ID;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus Status;
	@Column(name = "enrollment_date")
	private LocalDateTime EnrollmentDate;
	
	public TournamentEnrollment() {

	}

	public Long getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(Long user_ID) {
		User_ID = user_ID;
	}

	public Long getTournament_ID() {
		return Tournament_ID;
	}

	public void setTournament_ID(Long tournament_ID) {
		Tournament_ID = tournament_ID;
	}

	public PaymentStatus getStatus() {
		return Status;
	}

	public void setStatus(PaymentStatus status) {
		Status = status;
	}

	public LocalDateTime getEnrollmentDate() {
		return EnrollmentDate;
	}

	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}

	@Override
	public String toString() {
		return "TournamentEnrollment [User_ID=" + User_ID + ", Tournament_ID=" + Tournament_ID + ", Status=" + Status
				+ ", EnrollmentDate=" + EnrollmentDate + "]";
	}
	
	
	
	
	
}
