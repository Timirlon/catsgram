package com.example.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {
    private static final Logger log = LoggerFactory.getLogger(SimpleController.class);
    @GetMapping("/hello")
    public String helloPage() {
        log.info("Получен запрос.");
        return "Hello world!";
    }
}
