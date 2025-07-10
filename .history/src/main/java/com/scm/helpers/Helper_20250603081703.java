package com.scm.helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;


public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication)
    {

         //email se direct
        if(authentication instanceof OAuth2AuthenticationToken){

            var OAuth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;
            var clientId = OAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            if(clientId.equalsIgnoreCase("google"))
            {
                 // sign in with google
                 System.out.println("getting email from google");

            } else if (clientId.equalsIgnoreCase("github"))
            {

                System.out.println("getting email from github");

            }

        return "";

    } else{

        System.out.println("getting email from local database");
        return authentication.getName();
    }

 }
}