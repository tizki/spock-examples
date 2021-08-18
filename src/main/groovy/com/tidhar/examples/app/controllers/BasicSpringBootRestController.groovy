package com.tidhar.examples.app.controllers

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasicSpringBootRestController {

    @GetMapping("/")
    String index() {
        return "Greetings from Spring Boot!";
    }

}


