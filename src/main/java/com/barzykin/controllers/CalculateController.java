package com.barzykin.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    // http://localhost:8080/webmvc/calculate/3/plus/4

    @GetMapping(value = "/calculate/{a}/plus/{b}")
    public String plus(@PathVariable int a, @PathVariable int b) {
        return a + " + " + b + " = " + (a + b);
    }
}
