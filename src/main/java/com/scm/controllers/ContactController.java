package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.forms.ContactForm;



@Controller
@RequestMapping("/user/contacts")
public class ContactController {


    @RequestMapping("/add")
    // add contact page
    public String addContactView(Model model) {

        ContactForm contactForm = new ContactForm();
        
        model.addAttribute("contactForm", contactForm);

        return "user/add_contact";
    }
}
