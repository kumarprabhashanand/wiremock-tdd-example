package com.tdd.wiremockexample.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MockController.class)
@WireMockTest(proxyMode = true)
public class MockControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testMockRequest_Get2XX() throws Exception {

        stubFor(WireMock
                .get("/mockapi/1234")
                .withHost(equalTo("somerestapi.com"))
                .willReturn(aResponse()
                        .withBody("Successfully Mocked").withStatus(200)));

        mockMvc.perform(get("/api/mock"))
                .andExpect(status().is2xxSuccessful());
    }

}
