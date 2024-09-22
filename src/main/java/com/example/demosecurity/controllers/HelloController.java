package com.example.demosecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("route1")
    public String sayHi1(Principal principal)
    {
        return "Hi route 1"+principal.getName();
    }
    @GetMapping("route2")
    public String sayHi2(Principal principal)
    {
        return "Hi route 2"+principal.getName();
    }



}
