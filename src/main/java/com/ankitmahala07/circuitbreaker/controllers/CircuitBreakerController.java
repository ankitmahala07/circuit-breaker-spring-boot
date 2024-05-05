package com.ankitmahala07.circuitbreaker.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RequestMapping("/cb")
@RestController
public class CircuitBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @CircuitBreaker(name = "doSomething", fallbackMethod = "fallbackMethod")
    public String doSomething() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://www.boredapi.com/api/activity", String.class);
        return responseEntity.getBody();
    }

    public String fallbackMethod(Throwable throwable){
        return "Response from fallback";
    }
}
