package com.github.rodmotta.jwtauthentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/user")
    public String greetUser(){
        return "Hello user!";
    }

    @GetMapping("/admin")
    public String greetAdmin(){
        return "Hello admin!";
    }
}
