package com.scm.helpers;

import java.util.UUID;  // Add this import
import org.springframework.stereotype.Component;

@Component
public class Helpers {

    /**
     * Generates a verification link for email confirmation
     * @param token The verification token
     * @return Complete verification URL
     */
    public String getLinkForEmailVerification(String token) {
        return "http://localhost:8080/api/verify-email?token=" + token;
    }

    /**
     * Generates a random 6-character code
     */
    public String generateRandomCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}