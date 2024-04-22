package com.mskim.webfluxmongodb.controller;

import com.mskim.webfluxmongodb.document.Table1Collection;
import com.mskim.webfluxmongodb.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@ResponseBody
public class MainController {

    @Autowired
    private Table1Repository table1Repository;

    @GetMapping("ms4/data")
    public Flux<Table1Collection> findAll() {
        return table1Repository.findAll();
    }
}
