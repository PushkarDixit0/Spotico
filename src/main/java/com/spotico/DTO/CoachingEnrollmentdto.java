package com.spotico.DTO;

import java.time.LocalDate;

import com.spotico.pojos.PaymentStatus;
import com.spotico.pojos.SportType;

public class CoachingEnrollmentdto extends Basedto {
	
private Long User_ID;
	
private Long CoachingSession_ID;

private Long Sport_ID;

private LocalDate EnrollmentDate;
	
private PaymentStatus PaymentType;

private SportType SportType;

public CoachingEnrollmentdto() {

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
	return "CoachingEnrollmentdto [User_ID=" + User_ID + ", CoachingSession_ID=" + CoachingSession_ID + ", Sport_ID="
			+ Sport_ID + ", EnrollmentDate=" + EnrollmentDate + ", PaymentType=" + PaymentType + ", SportType="
			+ SportType + "]";
}





}
