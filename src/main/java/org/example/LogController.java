package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class LogController {
    @GetMapping("/api/logs/log/mariya")
    public String getTextFromFile() throws IOException {
        String filePath = "log.txt";
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
