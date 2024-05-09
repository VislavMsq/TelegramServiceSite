package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("logs/log/mariya")
    public String redirectToMariya() {
        return "site/mariyalog";
    }
}
