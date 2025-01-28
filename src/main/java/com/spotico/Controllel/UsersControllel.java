package com.spotico.Controllel;



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
import com.spotico.pojos.Users;





@RestController
@RequestMapping("/user")
public class UsersControllel {

	@Autowired
	public UsersService usersService;

	
	
	public UsersControllel() {
		System.out.println("UsersService Running");
	}
	
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getMethodName() {
		return ResponseEntity.ok(usersService.getallUSers());
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<APIResponse> postMethodName(@RequestBody Users entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.saveuser(entity)));
	}
		return null;}
	
	
	
	
}
