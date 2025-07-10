package com.scm.services;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    /**
     * Sends an email to the specified recipient
     * @param toEmail Recipient email address
     * @param subject Email subject
     * @param body Email content
     */
    public void sendEmail(String toEmail, String subject, String body) {
        // TODO: Implement actual email sending logic
        // This is a stub implementation
        System.out.println("Email sent to: " + toEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        
        // In a real implementation, you would use:
        // JavaMailSender or Spring's Email libraries
    }
}