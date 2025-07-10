package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    private final UserService userService;

    @GetMapping("/") 
    public String index() {
        return "redirect:/home";
    }

    // ✅ Constructor injection — good practice
    public PageController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Substring technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult bindingResult,
            HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        // Manual construction of User entity
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://campussafetyconference.com/wp-content/uploads/2020/08/iStock-476085198.jpg");
        user.setEnabled(false);

        // Saving user via manually defined service
        userService.saveUser(user);

        // Set success message in session
        Message message = new Message();
        message.setContent("Registration successful!");
        message.setType(MessageType.blue);
        session.setAttribute("message", message);

        // Redirecting to register page (or consider redirect:/login for better UX)
        return "redirect:/register";
    }
}
