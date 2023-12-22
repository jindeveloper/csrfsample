package com.example.securitycsrfdemo.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MalicousController {

    @GetMapping("/malicious")
    public String getTodos() {
        return "malicious";
    }
}
