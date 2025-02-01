package com.spotico.Service;

import java.util.List;

import com.spotico.pojos.User;

public interface UsersService {

	List<User> getallUSers();

	String saveuser(User entity);

}
