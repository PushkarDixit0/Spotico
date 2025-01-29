package com.sportico.Controllel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportico.DTO.APIResponse;
import com.sportico.DTO.PostUserdto;
import com.sportico.Service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;





@RestController
@RequestMapping("/user")
public class UsersControllel {

	@Autowired
	public UsersService usersService;

	
	
	public UsersControllel() {
		System.out.println("UsersService Running");
	}
	
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getMethodGetAll() {
		return ResponseEntity.ok(usersService.getallUSers());
	}

	@PostMapping("/saveUser")
	public ResponseEntity<APIResponse> postMethodInsert(@RequestBody PostUserdto entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.saveuser(entity)));
	}
		return null;
		
	}
	
	@PutMapping("/saveUser/{userid}")
	public ResponseEntity<APIResponse> putMethodUpdate(@PathVariable Long userid, @RequestBody PostUserdto entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.Updateuser(userid, entity)));
	}
		return null;
		
	}
	
	
	
	
	
	
	
}
