package com.vt;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void sendMailWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException
	 {
		
		  MimeMessage message = emailSender.createMimeMessage();
	      
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
		     
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(text);
		         
		    FileSystemResource file 
		      = new FileSystemResource(new File(pathToAttachment));
		    helper.addAttachment("Invoice", file);
		 
		    emailSender.send(message);
	}

}
