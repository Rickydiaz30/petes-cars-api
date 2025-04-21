package com.rickydiaz30.petescars.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInquiry(String subject, String body, String replyTo) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("8b10da001@smtp-brevo.com");  // ✅ Must match Brevo sender
        message.setTo("diazricky28@gmail.com");       // ✅ You get the email
        message.setSubject(subject);
        message.setText(body);
        message.setReplyTo(replyTo);                  // ✅ Enables replying to the user's email

        mailSender.send(message);
    }

    public void sendConfirmation(String toEmail, String carName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("8b10da001@smtp-brevo.com"); // Brevo sender
        message.setTo(toEmail);                      // send to the customer
        message.setSubject("We received your inquiry about the " + carName);
        message.setText(
                "Hi,\n\nThank you for your interest in the " + carName +
                        ". We'll get back to you shortly.\n\n– Pete's Cars"
        );

        mailSender.send(message);
    }

}

