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
}

