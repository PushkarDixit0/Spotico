package com.sportico.Service;

import java.util.List;

import com.sportico.DTO.CoachingSessiondto;

public interface CoachingSessionService{

	List<CoachingSessiondto> getallSession();

	String savesession(CoachingSessiondto entity);

	List<CoachingSessiondto> getallSessionCID(Long cid);
//
	List<CoachingSessiondto> getallSessionSID(Long sid);

}
