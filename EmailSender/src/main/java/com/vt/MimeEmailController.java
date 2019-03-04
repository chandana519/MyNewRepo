package com.vt;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MimeEmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping("/sendMailWithAttachment")
	public ResponseEntity<?> sendMailWithAttachment() throws MessagingException {
		emailService.sendMailWithAttachment("chandushanmu01@gmail.com", "Mail from java Application",
				"Hai,How R U??????","C:\\Users\\Chanti\\Desktop\\Resumes\\naukri\\Resume.docx");
		return new ResponseEntity<>("mail sent successfully", HttpStatus.OK);
	}
}
