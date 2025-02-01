package com.sportico.DTO;

import com.sportico.pojos.PaymentStatus;
import com.sportico.pojos.SportType;

public class CoachingEnrollmentdto extends Basedto {
	
private Long UserId;
	
private Long CoachingSessionId;

private Long SportId;
	
private PaymentStatus PaymentType;

private SportType SportType;

public CoachingEnrollmentdto() {

	
}

public Long getUserId() {
	return UserId;
}

public void setUserId(Long userId) {
	UserId = userId;
}

public Long getCoachingSessionId() {
	return CoachingSessionId;
}

public void setCoachingSessionId(Long coachingSessionId) {
	CoachingSessionId = coachingSessionId;
}

public Long getSportId() {
	return SportId;
}

public void setSportId(Long sportId) {
	SportId = sportId;
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
	return "CoachingEnrollmentdto [UserId=" + UserId + ", CoachingSessionId=" + CoachingSessionId + ", SportId="
			+ SportId +", PaymentType=" + PaymentType + ", SportType="
			+ SportType + "]";
}







}
