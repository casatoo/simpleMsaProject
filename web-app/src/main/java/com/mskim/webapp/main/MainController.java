package com.mskim.webapp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("ms1/main")
    public String main() {
        return "main/main";
    }

}
