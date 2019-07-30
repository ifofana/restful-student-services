package com.ia.restfulstudentservices.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMailTLS {

	public static void main(String[] args) {
		
		final String username = "ibrahima.fofana.ia@gmail.com";
		final String password = "fe133aeb-cc50-4a92-a47e-48980215834f";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.elasticemail.com");
		prop.put("mail.smtp.port", "2525");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		
		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});
		
		try {
			Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ibrahima.fofana.ia@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ifofana75@gmail.com, ifofana75@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
