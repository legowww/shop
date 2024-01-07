package com.ecm.coreapi.controller.productsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchTestPageController {

    @GetMapping("/")
    public String searchPage() {
        return "search-page";
    }
}
