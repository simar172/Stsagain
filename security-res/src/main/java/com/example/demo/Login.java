package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
class Login {
    @GetMapping("/login")
    public String login() {

        return "Login";
    }

}
