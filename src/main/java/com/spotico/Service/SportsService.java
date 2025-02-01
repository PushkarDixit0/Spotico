package com.spotico.Service;

import java.util.List;

import com.spotico.DTO.SportDTO;

public interface SportsService {

	List<SportDTO> getAllSports();

	SportDTO addSport(SportDTO sp);

}
