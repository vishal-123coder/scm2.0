package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.helpers.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("user dashboard page loading...");
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Principal principal) {

       String username=Helper.getEmailOfLoggedInUser(principal);
        
        logger.info("user logged in: {}", username);
        
        System.out.println("user profile page loading...");
        return "user/profile";
    }

    // user add contacts page

    // user view contacts page

    // user edit contacts page

    // user delete contacts page

    // user search contacts page

}
