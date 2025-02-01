package com.sportico.Controllel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportico.DTO.APIResponse;
import com.sportico.DTO.PostUserdto;
import com.sportico.Service.UsersService;






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
		return ResponseEntity.ok(usersService.getallUSERS());
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<?> GetMethodUser(@PathVariable Long userid) {
		return ResponseEntity.ok(usersService.GetuserbyId(userid));
	}

	@PostMapping("/saveuser")
	public ResponseEntity<?> postMethodInsertUSER(@RequestBody PostUserdto entity) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(usersService.saveuser(entity)));
	}
	
	
	@PostMapping("/saveoach")
	public ResponseEntity<?> postMethodInsertCOACH(@RequestBody PostUserdto entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(usersService.savecoach(entity)));
	}
		return null;		
	}
	
	
	
	
	
	
	@PutMapping("/UpdateUser/{userid}")
	public ResponseEntity<?> putMethodUpdate(@PathVariable Long userid, @RequestBody PostUserdto entity) {
		if(entity!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.Updateuser(userid, entity)));
	}
		return null;
		
	}
	
	@PutMapping("/UpdateEmailUser/{userid}")
	public ResponseEntity<?> putMethodEmailUpdate(@PathVariable Long userid, @RequestBody String Email) {
		if(Email!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.UpdateuserEmail(userid, Email)));
	}
		return null;
		
	}
	
	@PutMapping("/UpdatePassUser")
	public ResponseEntity<?> putMethodPassUpdate(@RequestBody String Email,@RequestBody  String OLDPasswd, @RequestBody  String NEWPasswd) {
		if(Email!=null) {
		return  ResponseEntity.status(HttpStatus.ACCEPTED).body(new APIResponse(usersService.UpdateuserPass(Email,OLDPasswd,NEWPasswd)));
	}
		return null;
		
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> DeleteMethodUser(@PathVariable Long userid) {
		return ResponseEntity.ok(new APIResponse(usersService.deleteuser(userid)));
	}
	
	

	@GetMapping("/allcoach")
	public ResponseEntity<?> getMethodAllCoach() {
		return ResponseEntity.ok(usersService.getallCoach());
	}

	
	@GetMapping("/allusers")
	public ResponseEntity<?> getMethodAllusers() {
		return ResponseEntity.ok(usersService.getallusers());
	}

	
	
	
	
	
	
	
	
	
	
}
