package com.anomalia.backend.controller;

import com.anomalia.backend.model.WeatherAnomaly;
import com.anomalia.backend.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetWeatherAnomalies() throws Exception {
        WeatherAnomaly w = new WeatherAnomaly();
        w.setId("w-001");
        w.setCity("Mumbai");
        w.setTemperature(42.3);
        w.setHumidity(80);
        w.setWindSpeed(12.4);
        w.setTimestamp(Instant.now());

        Mockito.when(weatherService.getAllRecent()).thenReturn(List.of(w));

        mockMvc.perform(get("/api/weather"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("w-001"))
                .andExpect(jsonPath("$[0].city").value("Mumbai"));
    }
}
