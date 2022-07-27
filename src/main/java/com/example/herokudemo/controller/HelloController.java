package com.example.herokudemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHelloResponse(@RequestParam("name") String name) {

        return "Hello, " + name + "! Your web-application is fine";
    }
}

