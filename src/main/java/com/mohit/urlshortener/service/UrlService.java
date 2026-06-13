package com.mohit.urlshortener.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mohit.urlshortener.entity.Url;
import com.mohit.urlshortener.repository.UrlRepository;
import com.mohit.urlshortener.util.Base62Util;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url createShortUrl(
            String originalUrl,
            String customCode,
            com.mohit.urlshortener.entity.User user) {

        Url url = new Url();

        url.setOriginalUrl(originalUrl);
        url.setUser(user);

        if (customCode != null &&
            !customCode.isBlank()) {

            if (urlRepository
                    .findByShortCode(customCode)
                    .isPresent()) {

                throw new RuntimeException(
                        "Custom code already exists");
            }

            url.setShortCode(customCode);

            return urlRepository.save(url);
        }

        Url savedUrl = urlRepository.save(url);

        String shortCode =
                Base62Util.encode(savedUrl.getId());

        savedUrl.setShortCode(shortCode);

        return urlRepository.save(savedUrl);
    }

    @Cacheable(value = "urls", key = "#shortCode")
    public Url getUrlByShortCode(String shortCode) {

        System.out.println("🔥 FETCHING FROM DATABASE: " + shortCode);

        return urlRepository
                .findByShortCode(shortCode)
                .orElse(null);
    }

    @Cacheable("test")
    public String testCache(String name) {

        System.out.println("CACHE MISS -> " + name);

        return "Hello " + name;
    }
}