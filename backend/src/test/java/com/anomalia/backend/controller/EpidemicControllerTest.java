package com.anomalia.backend.controller;

import com.anomalia.backend.model.EpidemicEvent;
import com.anomalia.backend.service.EpidemicService;
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

@WebMvcTest(EpidemicController.class)
public class EpidemicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EpidemicService epidemicService;

    @Test
    public void testGetEpidemicEvents() throws Exception {
        EpidemicEvent e = new EpidemicEvent();
        e.setId("ep-001");
        e.setDiseaseName("Dengue");
        e.setCountry("India");
        e.setConfirmedCases(2300);
        e.setDeaths(24);
        e.setTimestamp(Instant.now());

        Mockito.when(epidemicService.getAllRecent()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/epidemics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("ep-001"))
                .andExpect(jsonPath("$[0].diseaseName").value("Dengue"));
    }
}
