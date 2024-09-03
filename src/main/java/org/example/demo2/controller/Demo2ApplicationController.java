package org.example.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2ApplicationController {

    // Mapping for the root endpoint
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World from Spring Boot";
    }

    // Mapping for the /goodbye endpoint
    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye from Spring Boot";
    }
}
