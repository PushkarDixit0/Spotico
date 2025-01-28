package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.TournamentEnrollment;

public interface TournamentEnrollmentDao extends JpaRepository<TournamentEnrollment, Long> {

}
