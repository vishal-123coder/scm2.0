package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");
        //sending data to view
        model.addAttribute("name", "Substring technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        model.addAttribute("githubRepo",  "https://github.com/learncodewithdurgesh/");
        return "home";
    }
    // about route

    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("about page loading...");
        return "about";
    }

    // service route
    // @RequestMapping("/services")    
    // public String servicesPage(){
    //     System.out.println("services page loading...");
    //     return "services";
    // } 
}
