package com.anomalia.backend.controller;

import com.anomalia.backend.model.MarketAnomaly;
import com.anomalia.backend.service.MarketService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

@WebMvcTest(MarketController.class)
@Import(MarketControllerTest.Config.class)
public class MarketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MarketService marketService;

    @TestConfiguration
    static class Config {
        @Bean
        public MarketService marketService() {
            return Mockito.mock(MarketService.class);
        }
    }

    @Test
    public void testGetMarketAnomalies() throws Exception {
        MarketAnomaly m = new MarketAnomaly();
        m.setId("m-001");
        m.setSymbol("AAPL");
        m.setPriceChange(-3.45);
        m.setPercentChange(-2.3);
        m.setTimestamp(Instant.now());

        when(marketService.getAllRecent()).thenReturn(List.of(m));

        mockMvc.perform(get("/api/markets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("m-001"))
                .andExpect(jsonPath("$[0].symbol").value("AAPL"));
    }
}
