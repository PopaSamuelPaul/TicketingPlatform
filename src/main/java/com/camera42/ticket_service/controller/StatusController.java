package com.camera42.ticket_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @GetMapping
    public String checkStatus() {
        return "Ticketing is up";
    }
}
