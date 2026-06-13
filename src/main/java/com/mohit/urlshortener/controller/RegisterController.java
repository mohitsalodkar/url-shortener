package com.mohit.urlshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mohit.urlshortener.entity.User;
import com.mohit.urlshortener.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    
    @PostMapping("/register")
    public String register(User user) {

        userService.register(user);

        return "redirect:/login";
    }
}