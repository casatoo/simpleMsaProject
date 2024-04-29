package com.mskim.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@ResponseBody
public class DataController {

    // 서킷 브레이커 테스트를 위한 맵핑
    @GetMapping("/ms1/data")
    public String dataP() {

        String nowTime = LocalDateTime.now().toString();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 요청이 왔을 때 일정시간 이후 리턴
        return nowTime;
    }

}
