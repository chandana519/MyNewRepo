package com.vt;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);

	public void sendMailWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException;
}
