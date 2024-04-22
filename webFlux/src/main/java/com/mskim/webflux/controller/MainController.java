package com.mskim.webflux.controller;

import com.mskim.webflux.entity.DataEntity;
import com.mskim.webflux.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@ResponseBody
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("ms3/data")
    public Flux<DataEntity> mainP() {
        return mainService.getData();
    }
}
