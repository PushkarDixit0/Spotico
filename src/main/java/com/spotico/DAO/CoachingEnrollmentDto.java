package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.CoachingEnrollment;

public interface CoachingEnrollmentDto extends JpaRepository<CoachingEnrollment, Long> {

}
