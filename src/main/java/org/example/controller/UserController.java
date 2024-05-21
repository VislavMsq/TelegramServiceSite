package org.example.controller;

import org.example.entity.subscriber.dto.WebUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/new")
    public String register(@RequestBody WebUserDto webUserDto) {



        return "redirect:/login";
    }
}
