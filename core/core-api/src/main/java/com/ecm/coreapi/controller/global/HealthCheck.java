package com.ecm.coreapi.controller.global;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/ping")
    public String ping() {
        return "Server1 On";
    }
}
