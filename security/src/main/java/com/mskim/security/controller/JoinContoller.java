package com.mskim.security.controller;

import com.mskim.security.dto.JoinDTO;
import com.mskim.security.service.JoinService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinContoller {

    @Resource
    JoinService joinService;

    @GetMapping("/security/join")
    public String joinP() {

        return "/login/join";
    }

    @PostMapping("/security/joinProc")
    public String joinProcess(JoinDTO joinDTO) {

        joinService.joinProcess(joinDTO);

        return "redirect:/security/login";
    }

}
