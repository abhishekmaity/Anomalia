package com.anomalia.backend.controller;

import com.anomalia.backend.dto.EpidemicEventDTO;
import com.anomalia.backend.service.EpidemicService;
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
class EpidemicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EpidemicService epidemicService;

    @Test
    void getRecentReturnsPage() throws Exception {
        // Given a sample DTO object
        EpidemicEventDTO dto = new EpidemicEventDTO();
        dto.setId("test-epidemic-id");
        dto.setDiseaseName("COVID-19");
        dto.setCountry("IND");
        dto.setConfirmedCases(10000);
        dto.setDeaths(500);
        dto.setTimestamp(Instant.now());

        // Create a mock page
        Page<EpidemicEventDTO> page = new PageImpl<>(List.of(dto), PageRequest.of(0, 10), 1);
        when(epidemicService.getRecentEvents(0, 10)).thenReturn(page);

        // Perform the GET request
        mockMvc.perform(get("/api/epidemics/recent")
                        .param("page", "0")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].country").value("IND"))
                .andExpect(jsonPath("$.content[0].diseaseName").value("COVID-19"))
                .andExpect(jsonPath("$.content[0].confirmedCases").value(10000))
                .andExpect(jsonPath("$.content[0].deaths").value(500));
    }
}
