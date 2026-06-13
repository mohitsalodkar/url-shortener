package com.mohit.urlshortener.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.urlshortener.entity.Url;
import com.mohit.urlshortener.entity.User;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findByShortCode(String shortCode);

    List<Url> findByUser(User user);

    Optional<Url> findByIdAndUser(Long id, User user);

    List<Url> findTop5ByOrderByClickCountDesc();

    List<Url> findAllByOrderByIdAsc();

}