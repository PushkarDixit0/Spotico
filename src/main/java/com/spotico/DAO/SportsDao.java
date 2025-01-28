package com.spotico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotico.pojos.Sports;

public interface SportsDao extends JpaRepository<Sports, Long> {

}
