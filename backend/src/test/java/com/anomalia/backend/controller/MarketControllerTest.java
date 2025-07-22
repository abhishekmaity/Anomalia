package com.anomalia.backend.controller;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.service.MarketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MarketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MarketService marketService;

    @Test
    void getRecentReturnsPage() throws Exception {
        MarketAnomalyDTO dto = new MarketAnomalyDTO();
        dto.setId("btc-usd");
        dto.setSymbol("BTCUSD");
        dto.setPrice(61750.25);
        dto.setExchange("Coinbase");
        dto.setTimestamp(Instant.now());

        Page<MarketAnomalyDTO> page = new PageImpl<>(List.of(dto));
        when(marketService.getRecentEvents(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/market/recent")
                        .param("page", "0")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].symbol").value("BTCUSD"))
                .andExpect(jsonPath("$.content[0].price").value(61750.25));
    }
}
