package com.anomalia.backend.controller;

import com.anomalia.backend.model.EpidemicEvent;
import com.anomalia.backend.service.EpidemicService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;

@WebMvcTest(EpidemicController.class)
@Import(EpidemicControllerTest.Config.class)
public class EpidemicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EpidemicService epidemicService;

    @TestConfiguration
    static class Config {
        @Bean
        public EpidemicService epidemicService() {
            return Mockito.mock(EpidemicService.class);
        }
    }

    @Test
    public void testGetEpidemicEvents() throws Exception {
        EpidemicEvent e = new EpidemicEvent();
        e.setId("ep-001");
        e.setDiseaseName("Dengue");
        e.setCountry("India");
        e.setConfirmedCases(2300);
        e.setDeaths(24);
        e.setTimestamp(Instant.now());

        when(epidemicService.getAllRecent()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/epidemics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("ep-001"))
                .andExpect(jsonPath("$[0].diseaseName").value("Dengue"));
    }
}
