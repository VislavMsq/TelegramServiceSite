package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/logs/log")
public class LogController {
    @GetMapping("/mariya")
    public String getTextFromFile() throws IOException {
        String filePath = "log.txt";
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
