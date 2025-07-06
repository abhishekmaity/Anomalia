package com.anomalia.backend.controller;

import com.anomalia.backend.model.EarthquakeEvent;
import com.anomalia.backend.service.EarthquakeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(EarthquakeController.class)
public class EarthquakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EarthquakeService earthquakeService;

    @InjectMocks
    private EarthquakeController earthquakeController;

    @Test
    public void testGetRecentEarthquakes() throws Exception {
        EarthquakeEvent e = new EarthquakeEvent();
        e.setId("eq-001");
        e.setLocation("California");
        e.setMagnitude(5.8);
        e.setLatitude(36.7);
        e.setLongitude(-121.6);
        e.setTimestamp(Instant.now());

        Mockito.when(earthquakeService.getAllRecent()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/earthquakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("eq-001"))
                .andExpect(jsonPath("$[0].location").value("California"));
    }
}
