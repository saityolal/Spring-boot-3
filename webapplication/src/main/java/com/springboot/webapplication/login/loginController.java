package com.springboot.webapplication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class loginController {

    @Autowired
    public AuthenticationService authenticationService;

   
    // @RequestMapping(value="login", method= RequestMethod.GET)        // Spring security already provide login page 
    // public String login() {
    //     return "login";

    // }
    // @RequestMapping(value="login", method= RequestMethod.POST)
    // public String welcome(@RequestParam String name,@RequestParam String password, Model model) {

    //     model.addAttribute("name", name);
    //     model.addAttribute("password", password);

    //    if(authenticationService.authenticate(name, password)){

    //        return "welcome";

    //     }   
    //    model.addAttribute("error", "Invalid Credentials");
    //     return "login";
    //    // return "welcome";

    // }
    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", authenticationService.getLoggedinUsername());
        return "welcome";

    }
}