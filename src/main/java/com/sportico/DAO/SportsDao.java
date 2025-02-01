package com.sportico.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportico.pojos.Sports;

public interface SportsDao extends JpaRepository<Sports, Long> {

}
