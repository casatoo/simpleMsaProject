package com.mskim.webflux.controller;

import com.mskim.webflux.firstdb.entity.FirstEntity;
import com.mskim.webflux.firstdb.repository.FirstRepository;
import com.mskim.webflux.seconddb.entity.SecondEntity;
import com.mskim.webflux.seconddb.repository.SecondRepository;
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

    @GetMapping("ms3/first/db")
    public Flux<FirstEntity> first() {
        return mainService.getFirst();
    }

    @GetMapping("ms3/second/db")
    public Flux<SecondEntity> second() {
        return mainService.getSecond();
    }
}
