package com.clockworkjava.kursspring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

}
