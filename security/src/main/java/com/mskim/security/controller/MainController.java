package com.mskim.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/security/main")
    public String mainP() {

        return "/main/main";
    }
}
