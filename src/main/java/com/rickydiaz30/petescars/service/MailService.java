package com.rickydiaz30.petescars.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInquiry(String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("diazricky28@gmail.com");
        message.setTo("diazricky28@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
