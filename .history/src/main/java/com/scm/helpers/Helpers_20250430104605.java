package com.scm.helpers;

import org.springframework.stereotype.Component;

@Component
public class Helpers {

    /**
     * Generates a verification link for email confirmation
     * @param token The verification token
     * @return Complete verification URL
     */
    public String getLinkForEmailVerification(String token) {
        // TODO: Replace with your actual domain and endpoint
        return "http://localhost:8080/api/verify-email?token=" + token;
    }

    /**
     * Additional helper methods can be added here
     */
    public String generateRandomCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}