package com.mohit.urlshortener.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.urlshortener.entity.Url;
import com.mohit.urlshortener.repository.UrlRepository;
import com.mohit.urlshortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RedirectController {

    private final UrlRepository urlRepository;
    private final UrlService urlService;

    public RedirectController(
            UrlRepository urlRepository,
            UrlService urlService) {

        this.urlRepository = urlRepository;
        this.urlService = urlService;
    }

    @GetMapping("/cache-test/{name}")
    public String cacheTest(@PathVariable String name) {

        return urlService.testCache(name);
    }

    @GetMapping("/{shortCode}")
    public void redirectToOriginalUrl(
            @PathVariable String shortCode,
            HttpServletResponse response) throws IOException {

        Url url = urlService.getUrlByShortCode(shortCode);

        if (url != null) {

            url.setClickCount(url.getClickCount() + 1);

            urlRepository.save(url);

            response.sendRedirect(url.getOriginalUrl());

        } else {

            response.getWriter().write("Short URL Not Found");
        }
    }
}