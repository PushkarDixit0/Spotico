package com.spotico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotico.DAO.UsersDao;
import com.spotico.pojos.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	public UsersDao userDao;
	
	
	@Override
	public List<Users> getallUSers() {
		List<Users> alluser=userDao.findAll();
		return alluser;
	}


	@Override
	public String saveuser(Users entity) {
		userDao.save(entity);
		return "Successfully save";
	}

}
