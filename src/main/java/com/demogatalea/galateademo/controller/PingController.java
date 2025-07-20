package com.demogatalea.galateademo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PingController {
    @GetMapping("/ping")
    public String ping() {
        return "API funcionando";
    }
}