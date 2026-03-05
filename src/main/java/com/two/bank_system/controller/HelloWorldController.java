package com.two.bank_system.controller;

import com.two.bank_system.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    //GET in endpoint '/hello-world'
    @GetMapping
    public String helloword() {
        return helloWorldService.helloWorld(); 
    }
}
