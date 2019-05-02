package com.example.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloWorldController {


    @GetMapping("/sayHello/{name}")
    @ResponseBody
    public String helloWorld(@PathVariable String name) {
        String hello = "Hello, " + name + "!";
        return hello;
    }


    @GetMapping("/caps/{val}")
    @ResponseBody
    public String capitalize(@PathVariable String val) {
        String newVal = val.toUpperCase();
        return newVal;
    }
}
