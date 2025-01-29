package com.sportico.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportico.DAO.UsersDao;
import com.sportico.DTO.GetUserdto;
import com.sportico.DTO.PostUserdto;
import com.sportico.pojos.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	public UsersDao userDao;
	
	@Autowired
	public ModelMapper mapper;
	
	@Override
	public List<GetUserdto> getallUSers() {
		List<User> alluser=userDao.findAll();
		return alluser.stream()
				.map(user-> mapper.map(user, GetUserdto.class))
				.collect(Collectors.toList());
	
	}


	@Override
	public String saveuser(PostUserdto entity) {
		if(entity!=null) {
			User user=mapper.map(entity, User.class);
			userDao.save(user);
			return "Successfully save";
		}
		else {
			return "input data is invalid";
		}
	}


	@Override
	public String Updateuser(Long userid,PostUserdto entity) {
		if(entity!=null) {
			
			User user=userDao.findById(userid).orElseThrow();
			if(entity!=null) {
			User u=mapper.map(entity, User.class);
			user.setDOB(u.getDOB());
			user.setFName(u.getFName());
			user.setLName(u.getLName());
				
			}
			
			
			userDao.save(user);
			return "Successfully Updated";
		}
		else {
			return null;
		}
	}
	
	
	
	

}
