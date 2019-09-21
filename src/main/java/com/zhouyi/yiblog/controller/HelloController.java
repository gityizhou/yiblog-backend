package com.zhouyi.yiblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/show1")
    public String helloWorld(){
        return "<h1>Hello Spring boot2</h1>";
    }
}
