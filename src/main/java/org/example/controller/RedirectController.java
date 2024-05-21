package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("logs/log/mariya")
    public String redirectToMariya() {
        return "site/mariyalog";
    }

    @GetMapping("statistics/stats")
    public String redirectToStats() {
        return "site/stats";
    }

    @GetMapping("constructor/poll")
    public String redirectToPoll() {
        return "site/constructor/poll";
    }

    @GetMapping("home")
    public String redirectToHome() {
        return "site/home";
    }

    @GetMapping
    public String redirectToHome1() {
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String redirectToLogin() {
        return "login";
    }

}