package com.cignex.rahul.Springmail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		Session session = Session.getInstance(properties, new Authenticator()
		{
		@Override
		protected PasswordAuthentication getPasswordAuthentication()
		{
		return new PasswordAuthentication("yourEmail", "yourpass.");
		}
		});
		

		try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("yourEmail"));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
		message.setSubject(subject);
		message.setContent(text,"text/html");
		Transport.send(message);
		System.out.println("Mail has been sent");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}