package com.scm.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.forms.ContactForm;
import com.scm.helpers.Helper;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.ContactService;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;


    // ------------------------------
    //  SHOW ADD CONTACT PAGE
    // ------------------------------
    @RequestMapping("/add")
    public String addContactView(Model model) {

        model.addAttribute("contactForm", new ContactForm());
        return "user/add_contact";
    }


    // ------------------------------
    //  HANDLE ADD CONTACT SUBMISSION
    // ------------------------------
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(
            @Valid @ModelAttribute("contactForm") ContactForm contactForm,
            BindingResult result,
            Authentication authentication,
            HttpSession session) {

        logger.info("Contact Form Submitted: {}", contactForm);

        // ------------------------------
        //  VALIDATION ERRORS
        // ------------------------------
        if (result.hasErrors()) {

            session.setAttribute("message",
                    Message.builder()
                            .content("Please correct the errors below.")
                            .type(MessageType.red)
                            .build()
            );

            return "user/add_contact";
        }

        // ------------------------------
        //  GET LOGGED-IN USER
        // ------------------------------
        String username = Helper.getEmailOfLoggedInUser(authentication);
        User user = userService.getUserByEmail(username);


        // ------------------------------
        //  LOG UPLOADED IMAGE
        // ------------------------------
        if (contactForm.getProfileImage() != null && !contactForm.getProfileImage().isEmpty()) {
            logger.info("Uploaded Image: {}", contactForm.getProfileImage().getOriginalFilename());
        } else {
            logger.info("No image uploaded");
        }


        // ------------------------------
        //  FORM --> ENTITY
        // ------------------------------
        Contact contact = new Contact();

        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setFavorite(contactForm.isFavorite());
        contact.setWebsiteLink(contactForm.getWebsiteLink());
        contact.setLinkedInLink(contactForm.getLinkedInLink());
        contact.setUser(user);


        // ------------------------------
        //  SAVE CONTACT IN DATABASE
        // ------------------------------
        // contactService.save(contact);
        logger.info("Contact saved successfully: {}", contact);


        // ------------------------------
        //  SESSION SUCCESS MESSAGE
        // ------------------------------
        session.setAttribute("message",
                Message.builder()
                        .content("Your contact has been saved successfully!")
                        .type(MessageType.green)
                        .build()
        );

        return "redirect:/user/contacts/add";
    }
}
