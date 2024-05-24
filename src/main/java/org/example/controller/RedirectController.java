package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("logs/log/mariya")
    public String redirectToMariya() {
        return "site/secured/mariyalog";
    }

    @GetMapping("statistics/stats")
    public String redirectToStats() {
        return "site/secured/stats";
    }

    @GetMapping("constructor/poll")
    public String redirectToPoll() {
        return "site/secured/constructor/poll";
    }

    @GetMapping("home")
    public String redirectToHome() {
        return "site/all/home";
    }

    @GetMapping
    public String redirectToHome1() {
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String redirectToLogin() {
        return "site/all/login";
    }

    @GetMapping("/register")
    public String redirectToRegister() {
        return "site/all/register";
    }

    @GetMapping("/pollcabinet")
    public String redirectToPollCabinet() {
        return "site/secured/constructor/pollcabinet";
    }
    @GetMapping("/pollcabinet/active")
    public String redirectToActivePollCabinet() {
        return "site/secured/constructor/pollcabinet2";
    }
}