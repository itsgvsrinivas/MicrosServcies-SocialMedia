package com.gv.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class AppFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("[AppFilter] >> [filter]");

        //Validate the requests
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        HttpHeaders httpHeaders = serverHttpRequest.getHeaders();
        Set keySet = httpHeaders.keySet();

        /*if (!keySet.contains("authKey")) {
            throw new RuntimeException("Invalid Request- Missing secret key");
        }

        List<String> secretList = httpHeaders.get("authKey");
        if (!secretList.get(0).equals("ashokIt@123")) {
            throw new RuntimeException("Invalid secret key");
        }*/

        return chain.filter(exchange);
    }
}
