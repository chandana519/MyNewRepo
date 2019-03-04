package com.vt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleEmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping("/sendEmail")
	public ResponseEntity<?> sendEmail() {
		emailService.sendSimpleMessage("chandushanmu01@gmail.com", "Mail from java Application through sendgrid",
				"Hai,How R U??????");
		return new ResponseEntity<>("mail sent successfully", HttpStatus.OK);
	}
}
