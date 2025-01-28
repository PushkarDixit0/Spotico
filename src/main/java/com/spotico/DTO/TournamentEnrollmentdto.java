package com.spotico.DTO;

import java.time.LocalDateTime;

import com.spotico.pojos.PaymentStatus;

public class TournamentEnrollmentdto {
	
	private Long User_ID;
	
	private Long Tournament_ID;
	
	private PaymentStatus Status;
	
	private LocalDateTime EnrollmentDate;

	public TournamentEnrollmentdto() {
		
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
		return "TournamentEnrollmentdto [User_ID=" + User_ID + ", Tournament_ID=" + Tournament_ID + ", Status=" + Status
				+ ", EnrollmentDate=" + EnrollmentDate + "]";
	}
	
	
}
