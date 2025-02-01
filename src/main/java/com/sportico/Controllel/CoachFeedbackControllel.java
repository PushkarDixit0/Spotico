package com.sportico.Controllel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportico.DTO.APIResponse;
import com.sportico.DTO.CoachFeedbackdto;
import com.sportico.Service.CoachFeedbackService;


@RestController
@RequestMapping("/feedback")
public class CoachFeedbackControllel {

	@Autowired
	public CoachFeedbackService coachFeedbackService;
	
	
	
	
	public CoachFeedbackControllel() {
		super();
	System.out.println("Coach Feedback Running");
	}

	
	@GetMapping("AllFeedback")
	public ResponseEntity<?> getAllMethodFeedback() {
		return ResponseEntity.ok(coachFeedbackService.getallFeedback());
		}
	

	@PostMapping("/savefeedback")
	public ResponseEntity<?> postMethodInsertFeedback(@RequestBody CoachFeedbackdto entity) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(coachFeedbackService.savefeedback(entity)));
	}
	
	
	@PatchMapping("/updateMessage/{fid}")
	public ResponseEntity<?> postMethodUpdateFeedbackMessage(@PathVariable Long fid, @RequestBody String message) {
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse(coachFeedbackService.updateMessage(fid,message)));
	}
	
	
	@GetMapping("AllFeedbackByuid/{uid}")
	public ResponseEntity<?> getAllMethodFeedback(@PathVariable Long uid) {
		return ResponseEntity.ok(coachFeedbackService.userAllFeedback(uid));
		}
	
	
	@GetMapping("AllFeedbacksOfCid/{cid}")
	public ResponseEntity<?> getAllCidMethodFeedback(@PathVariable Long cid) {
		return ResponseEntity.ok(coachFeedbackService.CoachAllFeedback(cid));
		}
	
	
	
}
