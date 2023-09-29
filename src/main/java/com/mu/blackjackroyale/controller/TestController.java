package com.mu.blackjackroyale.controller;

import com.mu.blackjackroyale.dto.response.TestResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint() {
        var test = new TestResponseDTO("Wes", "Lambda");
        return ResponseEntity.ok(test);
    }
}
