package com.tdd.wiremockexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class MockController {

    @GetMapping("/mock")
    public String makeMockGetRequest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://somerestapi.com/mockapi/1234";
        String response = restTemplate.getForEntity(url, String.class)
                .getBody();
        System.out.println(response);
        return response;
    }

}
