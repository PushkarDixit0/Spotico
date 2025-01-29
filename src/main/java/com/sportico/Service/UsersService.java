package com.sportico.Service;

import java.util.List;

import com.sportico.DTO.GetUserdto;
import com.sportico.DTO.PostUserdto;



public interface UsersService {

	List<GetUserdto> getallUSers();

	String saveuser(PostUserdto entity);

	String Updateuser(Long userid,PostUserdto entity);

}
