package com.scm.controllers;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class PageController {

    private final UserService userService;

    public PageController(UserService userService) {
        this.userService = userService;
    }

    // Home redirect
    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    // Home page
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Substring technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        return "home";
    }

    // About page
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        return "about";
    }

    // Services page
    @RequestMapping("/services")
    public String servicesPage() {
        return "services";
    }

    // Contact page
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    // Login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Registration form page
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    // Registration processing
    @PostMapping("/do-register")
    public String processRegister(
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult bindingResult,
            HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Manually constructing User entity
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://campussafetyconference.com/wp-content/uploads/2020/08/iStock-476085198.jpg");
        user.setEnabled(false);

        // Save user using service
        userService.saveUser(user);

        // Success message
        Message message = new Message();
        message.setContent("Registration successful!");
        message.setType(MessageType.blue);
        session.setAttribute("message", message);

        return "redirect:/register";
    }

    // ✅ User profile page
    @GetMapping("/user/profile")
    public String userProfile(Model model, Principal principal) {
        String email = principal.getName(); // gets the logged-in user's email
        User user = userService.getUserByEmail(email);

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        return "user/profile"; // will render templates/user/profile.html
    }
}
