package com.anomalia.backend.controller;

import com.anomalia.backend.dto.EarthquakeEventDTO;
import com.anomalia.backend.service.EarthquakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EarthquakeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EarthquakeService earthquakeService;

    @Test
    void getRecentReturnsPage() throws Exception {
        EarthquakeEventDTO dto = new EarthquakeEventDTO();
        dto.setLocation("TestLocation");
        dto.setMagnitude(6.5);
        dto.setDepth(10.0);
        dto.setTime(LocalDateTime.now());

        Page<EarthquakeEventDTO> page = new PageImpl<>(List.of(dto));
        when(earthquakeService.getRecentEvents(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/earthquakes/recent")
                        .param("page", "0").param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].location").value("TestLocation"));
    }
}
