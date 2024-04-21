package com.mskim.springcloudgateway.component;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class G1Filter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 마이크로 서비스를 거치기 전 단계에서 수행하는 작업 영역
        System.out.println("pre global filter order -1");

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {

                    // 마이크로 서비스를 거친 후 수행하는 작업 영역
                    System.out.println("post global filter order -1");
        }));
    }

    @Override
    public int getOrder() {
        // 필터 순서
        return -1;
    }
}
