package com.mohit.urlshortener.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohit.urlshortener.repository.UrlRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import com.mohit.urlshortener.entity.User;
import com.mohit.urlshortener.entity.Url;
@Controller
public class AnalyticsController {

    private final UrlRepository urlRepository;

    public AnalyticsController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @GetMapping("/analytics")
    public String analytics(
            Model model,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {
            return "redirect:/login";
        }

        List<Url> userUrls =
                urlRepository.findAllByOrderByIdAsc()
                        .stream()
                        .filter(url ->
                                url.getUser() != null &&
                                url.getUser().getId()
                                        .equals(loggedInUser.getId()))
                        .toList();

        model.addAttribute("urls", userUrls);

        model.addAttribute("totalUrls",
                userUrls.size());

        model.addAttribute("totalClicks",
                userUrls.stream()
                        .mapToLong(url -> url.getClickCount())
                        .sum());

        model.addAttribute(
                "topUrls",
                userUrls.stream()
                        .sorted((a,b) ->
                                Long.compare(
                                        b.getClickCount(),
                                        a.getClickCount()))
                        .limit(5)
                        .toList());

        model.addAttribute("chartLabels",
                userUrls.stream()
                        .sorted((a,b) ->
                                Long.compare(
                                        b.getClickCount(),
                                        a.getClickCount()))
                        .limit(5)
                        .map(Url::getShortCode)
                        .toList());

        model.addAttribute("chartData",
                userUrls.stream()
                        .sorted((a,b) ->
                                Long.compare(
                                        b.getClickCount(),
                                        a.getClickCount()))
                        .limit(5)
                        .map(Url::getClickCount)
                        .toList());

        return "analytics";
    }

    @GetMapping("/export")
    public void exportCSV(
            HttpServletResponse response,
            HttpSession session) throws Exception {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {
            response.sendRedirect("/login");
            return;
        }

        response.setContentType("text/csv");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=urls.csv");

        PrintWriter writer = response.getWriter();

        writer.println("ID,Original URL,Short Code,Clicks");

        for (Url url : urlRepository.findByUser(loggedInUser)) {

            writer.println(
                    url.getId() + "," +
                    url.getOriginalUrl() + "," +
                    url.getShortCode() + "," +
                    url.getClickCount());
        }

        writer.flush();
        writer.close();
    }

    @GetMapping("/delete/{id}")
    public String deleteUrl(
            @PathVariable Long id,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if(loggedInUser == null) {
            return "redirect:/login";
        }

        Url url = urlRepository
                .findByIdAndUser(id, loggedInUser)
                .orElse(null);

        if(url != null) {
            urlRepository.delete(url);
        }

        return "redirect:/analytics";
    }
}