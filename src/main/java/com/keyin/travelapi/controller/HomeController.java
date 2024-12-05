package com.keyin.travelapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the final sprint Travel-API Spring Boot Application. Happy Coding hay hay hay!";
    }
}