package com.mskim.webflux.service;

import com.mskim.webflux.firstdb.entity.FirstEntity;
import com.mskim.webflux.firstdb.repository.FirstRepository;
import com.mskim.webflux.seconddb.entity.SecondEntity;
import com.mskim.webflux.seconddb.repository.SecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MainService {

    @Autowired
    private FirstRepository firstRepository;

    @Autowired
    private SecondRepository secondRepository;

    public Flux<FirstEntity> getFirst() {
        return firstRepository.findAll();
    }
    public Flux<SecondEntity> getSecond() {
        return secondRepository.findAll();
    }
}
