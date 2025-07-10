package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    // 🧭 User dashboard page
    @RequestMapping("/dashboard")
    public String userDashboard() {
        logger.info("Accessed user dashboard page");
        return "user/dashboard";
    }

    // 👤 User profile page
    @RequestMapping("/profile")
    public String userProfile(Model model, Authentication authentication) {
        String email = authentication.getName(); // get logged-in user email

        User user = userService.getUserByEmail(email); // get user from DB

        if (user == null) {
            logger.error("No user found with email: {}", email);
            model.addAttribute("error", "User not found!");
            return "error/404"; // or a fallback page
        }

        model.addAttribute("user", user);
        return "user/profile";
    }

    // ➕ Add contacts page (placeholder)
    @RequestMapping("/add-contact")
    public String addContactPage() {
        return "user/add_contact";
    }

    // 📄 View contacts page (placeholder)
    @RequestMapping("/view-contacts")
    public String viewContactsPage() {
        return "user/view_contacts";
    }

    // ✏️ Edit contact page (placeholder)
    @RequestMapping("/edit-contact")
    public String editContactPage() {
        return "user/edit_contact";
    }

    // 🗑️ Delete contact page (placeholder)
    @RequestMapping("/delete-contact")
    public String deleteContactPage() {
        return "user/delete_contact";
    }

    // 🔍 Search contact page (placeholder)
    @RequestMapping("/search-contact")
    public String searchContactPage() {
        return "user/search_contact";
    }
}
