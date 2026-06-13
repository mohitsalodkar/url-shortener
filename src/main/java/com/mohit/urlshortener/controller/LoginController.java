package com.mohit.urlshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohit.urlshortener.entity.User;
import com.mohit.urlshortener.service.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            jakarta.servlet.http.HttpSession session) {

        User user = userService.login(email, password);

        if(user != null) {

            session.setAttribute("loggedInUser", user);

            return "redirect:/analytics";
        }

        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(
            jakarta.servlet.http.HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }}