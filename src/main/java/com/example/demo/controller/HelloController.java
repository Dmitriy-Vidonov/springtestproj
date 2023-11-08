package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hellou")
    public String sayHello() { // http://localhost:8080/hellou  ->  Hello!!!
        return "Hello!!!";
    }
}
