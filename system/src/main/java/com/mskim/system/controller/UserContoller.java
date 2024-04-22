package com.mskim.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserContoller {

    @GetMapping("ms2/main")
    public String main() {
        return "sys/main";
    }
}
