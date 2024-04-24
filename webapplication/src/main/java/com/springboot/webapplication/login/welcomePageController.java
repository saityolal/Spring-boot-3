package com.springboot.webapplication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class welcomePageController {

    @Autowired
    public AuthenticationService authenticationService;

  
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("name", authenticationService.getLoggedinUsername());
        return "welcome";
        
    }

}