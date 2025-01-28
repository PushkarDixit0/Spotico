package com.spotico.Service;

import java.util.List;

import com.spotico.pojos.Users;

public interface UsersService {

	List<Users> getallUSers();

	String saveuser(Users entity);

}
