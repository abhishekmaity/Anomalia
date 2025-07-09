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

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
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
        dto.setTicker("AAPL");
        dto.setPrice(195.3);
        dto.setAnomalyScore(0.88);
        dto.setDate(LocalDate.now());

        Page<MarketAnomalyDTO> page = new PageImpl<>(List.of(dto));
        when(marketService.getRecentAnomalies(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/markets/recent")
                        .param("page", "0")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].ticker").value("AAPL"));
    }
}
