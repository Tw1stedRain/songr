package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/hello")

public class HelloWorld {


    @GetMapping("/{name}")
    @ResponseBody
    public String helloWorld(String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("/caps/{val}")
    @ResponseBody
    public String capitalize(@PathVariable String val) {
        String newVal = val.toUpperCase();
        return newVal;
    }
}
