package com.mskim.springjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login/page")
    public String loginP() {
        return "templates/login";
    }
}
