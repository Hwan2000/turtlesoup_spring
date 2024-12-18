package com.turtlesoup.backend.controller;

import com.turtlesoup.backend.dto.user.LoginRequest;
import com.turtlesoup.backend.config.security.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

//    @GetMapping("/home")
//    public String home(){
//        return "home";
//    }

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        if (principalDetails != null) {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("username", principalDetails.getUsername());
        } else {
            model.addAttribute("isAuthenticated", false);
        }
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("LoginRequest", loginRequest);
        return "login";
    }
}

