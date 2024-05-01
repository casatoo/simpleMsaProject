package com.mskim.springresilience.controller;

import com.mskim.springresilience.component.RestComponent;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

    private RestComponent restComponent;

    @Autowired
    public MainController(RestComponent restComponent) {
        this.restComponent = restComponent;
    }


    @GetMapping("/")
    public String mainP() {
        // 루트 경로로 접근 시 restComponent 에서 설정한 url + /ms1/data 를 호출 -> 설정한 시간 이후 응답 받음
        return restComponent.restTemplate().getForObject("/ms1/data", String.class);
    }

    @CircuitBreaker(name = "MainController_Method1", fallbackMethod = "fallBackMethod") // 이 서킷 브레이커의 명칭, 실패 시 실행할 메서드명
    @GetMapping("/circuitbreaker")
    public String circuitbreaker() {
        return restComponent.restTemplate().getForObject("/ms1/data", String.class);
    }


    @Retry(name="MainController_Method2",fallbackMethod = "fallBackMethod") // retry 명칭 , 실패 시 실행할 메서드명
    @GetMapping("/retry")
    public String retry() {
        return restComponent.restTemplate().getForObject("/ms1/data", String.class);
    }

    @Bulkhead(name = "MainController_Method3", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "fallBackMethod") // semaphore 방식 ( 요청갯수 제한 )
    @GetMapping("/bulkHeadSemaphore")
    public String bulkHeadSemaphore() {
        return restComponent.restTemplate().getForObject("/ms1/data", String.class);
    }

    @Bulkhead(name = "MainController_Method4", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "fallBackMethod") // threadpool 방식 ( 스레드 제한 )
    @GetMapping("/bulkHeadThreadpool")
    public String bulkHeadThreadpool() {
        return restComponent.restTemplate().getForObject("/ms1/data", String.class);
    }

    private String fallBackMethod(Throwable throwable) {
        return throwable.getMessage();
    }
}
