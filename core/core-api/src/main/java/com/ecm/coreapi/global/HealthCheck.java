package com.ecm.coreapi.global;


import com.ecm.coreapi.init.CacheInitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthCheck {

    private final CacheInitService cacheInitService;

    @GetMapping("/ping")
    public String ping() {
        return "Server On";
    }

    @GetMapping("/init")
    public void init() {
        cacheInitService.init();
    }
}

