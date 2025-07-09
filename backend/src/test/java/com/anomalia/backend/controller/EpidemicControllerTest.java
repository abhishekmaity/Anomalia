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

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
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
        EpidemicEventDTO dto = new EpidemicEventDTO();
        dto.setCountry("IND");
        dto.setIndicator("LifeExpectancy");
        dto.setValue(70.2);
        dto.setDate(LocalDate.now());

        Page<EpidemicEventDTO> page = new PageImpl<>(List.of(dto));
        when(epidemicService.getRecentEvents(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/epidemics/recent")
                        .param("page", "0").param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].country").value("IND"));
    }
}
