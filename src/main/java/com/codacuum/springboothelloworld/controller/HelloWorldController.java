package com.codacuum.springboothelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to Jenkins spring boot app - We are the best";
    }
}
