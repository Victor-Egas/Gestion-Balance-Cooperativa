package com.cooperativa.gestion.controller;

import com.cooperativa.gestion.model.entity.Partner;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    @GetMapping("/findAll")
    public ResponseEntity<String> getPartners() {
        String messageResponse = "Welcome to api cooperativa-balance";
        HttpHeaders headers = new HttpHeaders();
        headers.add("opn-number", "2");
        headers.add("region", "Lima");
        return ResponseEntity.ok()
                .headers(headers)
                .body(messageResponse);
    }
}
