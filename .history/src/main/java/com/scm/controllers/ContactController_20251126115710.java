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

    // Show Add Contact Form
    @RequestMapping("/add")
    public String addContactView(Model model) {
        ContactForm contactForm = new ContactForm();        
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }

    // Handle Contact Form Submission
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm, BindingResult result , Authentication authentication, HttpSession session) {
       
        // process form data

        // validate form
        if(result.hasErrors()){
            session.setAttribute("message", Message.builder()
            .content("Please correct the errors below.")
            .type(MessageType.red)
            .build());
              return "user/add_contact";
        }

        String username = Helper.getEmailOfLoggedInUser(authentication);


        // form --> contact
        User user = userService.getUserByEmail(username);

        //process the contact pic

        Contact contact = new Contact();

        contact.setName(contactForm.getName());
        contact.setFavorite(contactForm.isFavorite());
        contact.setEmail(contactForm.getEmail());
        contact.setPhoneNumber(contactForm.getPhoneNumber());
        contact.setAddress(contactForm.getAddress());
        contact.setDescription(contactForm.getDescription());
        contact.setUser(user);
        contact.setLinkedInLink(contactForm.getLinkedInLink());
        contact.setWebsiteLink(contactForm.getWebsiteLink());
        contactService.save(contact);

        // Debug: Print form values
        System.out.println("Received ContactForm: " + contactForm);
        System.out.println("Contact Name: " + contactForm.getName());
        System.out.println("Contact Email: " + contactForm.getEmail());
        System.out.println("Is Favorite: " + contactForm.isFavorite());


       
        System.out.println("Contact saved!");

        session.setAttribute("message", 
              Message.builder()
                 .content("\"Your contact has been saved successfully!")
                 .type(MessageType.green)
                 .build());
        return "redirect:/user/contacts/add";
    }
}
