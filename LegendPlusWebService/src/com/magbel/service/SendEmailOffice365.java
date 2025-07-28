package com.magbel.service;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailOffice365 {
	
	 private static final Logger LOGGER = Logger.getAnonymousLogger();

	    private static final String SERVIDOR_SMTP = "smtp.office365.com";
	    private static final int PORTA_SERVIDOR_SMTP = 587;
	    private static final String CONTA_PADRAO = "ayomidematanmi1@gmail.com";
	    private static final String SENHA_CONTA_PADRAO = "ayomide256";

	    private final String from = "ayomidematanmi1@gmail.com";
	    private final String to = "lekanmatanmi62@gmail.com";

	    private final String subject = "Test";
	    private final String messageContent = "I am testing something....";
	
	public void sendEmail() {
		Session session = Session.getDefaultInstance(getEmailProperties(), 
			   null);

        try {
            final Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(messageContent);
            message.setSentDate(new Date());
            Transport.send(message);
            System.out.println("Email Sent..");
        } catch (final MessagingException ex) {
            LOGGER.log(Level.WARNING, "Erro ao enviar mensagem: " + ex.getMessage(), ex);
        }
    }
	
	public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        config.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return config;
    }

    public static void main(final String[] args) {
        new SendEmailOffice365().sendEmail();
    }

}
