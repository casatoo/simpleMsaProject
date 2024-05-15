package com.mskim.oauthsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        // 뷰 반환
        return "mainView"; // "mainView" 뷰를 반환
    }
}
