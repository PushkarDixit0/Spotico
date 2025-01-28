package com.spotico.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
@Entity
@Table(name = "coachingEnrollment")
public class CoachingEnrollment extends BasicEntity {
	@Column(name = "user_id")
private Long User_ID;
	@Column(name = "coachingSession_id")
private Long CoachingSession_ID;
	@Column(name = "sport_id")
private Long Sport_ID;
	@Column(name = "enrollmentDate")
private LocalDate EnrollmentDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "paymentType")
private PaymentStatus PaymentType;
	@Enumerated(EnumType.STRING)
	@Column(name = "sportType")
private SportType SportType;
	public CoachingEnrollment() {
	}
	public Long getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(Long user_ID) {
		User_ID = user_ID;
	}
	public Long getCoachingSession_ID() {
		return CoachingSession_ID;
	}
	public void setCoachingSession_ID(Long coachingSession_ID) {
		CoachingSession_ID = coachingSession_ID;
	}
	public Long getSport_ID() {
		return Sport_ID;
	}
	public void setSport_ID(Long sport_ID) {
		Sport_ID = sport_ID;
	}
	public LocalDate getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	public PaymentStatus getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(PaymentStatus paymentType) {
		PaymentType = paymentType;
	}
	public SportType getSportType() {
		return SportType;
	}
	public void setSportType(SportType sportType) {
		SportType = sportType;
	}
	@Override
	public String toString() {
		return "CoachingEnrollment [User_ID=" + User_ID + ", CoachingSession_ID=" + CoachingSession_ID + ", Sport_ID="
				+ Sport_ID + ", EnrollmentDate=" + EnrollmentDate + ", PaymentType=" + PaymentType + ", SportType="
				+ SportType + "]";
	}
	
	
	
	
	
	
}
