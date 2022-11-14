package com.barzykin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculateController {

    // http://localhost:8080/webmvc/calculate/3/plus/4

    @RequestMapping(value = "/calculate/{a}/plus/{b}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String plus(@PathVariable int a, @PathVariable int b) {
        return a + " + " + b + " = " + (a + b);
    }
}
