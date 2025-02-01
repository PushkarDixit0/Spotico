package com.spotico.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotico.DTO.APIResponse;
import com.spotico.Service.UsersService;
import com.spotico.pojos.User;


@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	public UsersService usersService;
	
	public UsersController() {
		System.out.println("UsersService Running");
	}
	
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getMethodName() {
		return ResponseEntity.ok(usersService.getallUSers());
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<APIResponse> postMethodName(@RequestBody User entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.saveuser(entity)));
	}
		return null;}
	
	
	
	
}
