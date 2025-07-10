package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.helpers.Helper;
import com.scm.services.UserService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    


    //user dashboard page
    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("user dashboard page ");
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile")
    public String userProfile(Model model, Authentication authentication) {


        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in: {}", username);

        System.out.println("user profile page ");
        return "user/profile";
    }

    // user add contacts page

    // user view contacts page

    // user edit contacts page

    // user delete contacts page

    // user search contacts page

}
