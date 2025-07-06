package com.anomalia.backend.controller;

import com.anomalia.backend.model.MarketAnomaly;
import com.anomalia.backend.service.MarketService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MarketController.class)
public class MarketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarketService marketService;

    @Test
    public void testGetMarketAnomalies() throws Exception {
        MarketAnomaly m = new MarketAnomaly();
        m.setId("m-001");
        m.setSymbol("AAPL");
        m.setPriceChange(-3.45);
        m.setPercentChange(-2.3);
        m.setTimestamp(Instant.now());

        Mockito.when(marketService.getAllRecent()).thenReturn(List.of(m));

        mockMvc.perform(get("/api/markets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("m-001"))
                .andExpect(jsonPath("$[0].symbol").value("AAPL"));
    }
}
