package com.ibt.app;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController

// Class
public class Greeting {

    @GetMapping("/hello")
    // Easy method just to print encouraging and consoling words
    public String hello() {
        return "Hello IBT, this is a simple hello message to take care and have a nice day";
    }

    @GetMapping("/greet")
    //Easy method just to print greeting message by saying spring-based applications
    public String greet() {
        return "Hello Student, Welcome to IBT learning .";
    }
}
