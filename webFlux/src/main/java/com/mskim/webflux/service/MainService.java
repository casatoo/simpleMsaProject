package com.mskim.webflux.service;

import com.mskim.webflux.entity.DataEntity;
import com.mskim.webflux.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MainService {

    @Autowired
    private DataRepository dataRepository;

    public Flux<DataEntity> getData() {
        return dataRepository.findAll();
    }
}
