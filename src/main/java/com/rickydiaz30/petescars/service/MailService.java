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

    public void sendConfirmation(String toEmail, String carName, String customerName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("8b10da001@smtp-brevo.com");
        message.setTo(toEmail);
        message.setSubject("Thanks for your interest in the " + carName);
        message.setText(
                "Hi " + customerName + ",\n\n" +
                        "Thanks for reaching out to Pete’s Cars about the " + carName + ".\n\n" +
                        "We’ve received your inquiry and a member of our team will be in touch shortly to assist you.\n\n" +
                        "In the meantime, feel free to explore more vehicles on our website or reply to this email with any additional questions.\n\n" +
                        "We appreciate your interest!\n\n" +
                        "Best regards,\n" +
                        "Pete’s Cars\n" +
                        "123 Peachtree St NE, Atlanta, GA\n" +
                        "(555) 123-4567\n" +
                        "petescars.netlify.app"
        );

        mailSender.send(message);
    }


}

