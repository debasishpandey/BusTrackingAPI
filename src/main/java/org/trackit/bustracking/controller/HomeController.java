package org.trackit.bustracking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {
    @GetMapping("/")
    public String hello(){
        return "<h1>welcome to bustracking</h1>";
    }
}
