package com.mskim.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/security/admin")
    public String adminP() {
        return "/admin/admin";
    }
}
