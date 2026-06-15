package com.mohit.urlshortener.controller;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import com.mohit.urlshortener.dto.UrlRequest;
import com.mohit.urlshortener.dto.UrlResponse;
import com.mohit.urlshortener.entity.Url;
import com.mohit.urlshortener.service.UrlService;
import com.mohit.urlshortener.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public UrlResponse shortenUrl(
            @RequestBody UrlRequest request,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Please login first");
        }

        Url url = urlService.createShortUrl(
                request.getOriginalUrl(),
                request.getCustomCode(),
                loggedInUser);

        return new UrlResponse(
        	    "https://url-shortener-v71n.onrender.com/" +
        	    url.getShortCode()
        	);
    }
}