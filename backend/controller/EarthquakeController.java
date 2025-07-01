package com.anomalia.backend.controller;

import com.anomalia.backend.model.EarthquakeEvent;
import com.anomalia.backend.service.EarthquakeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/earthquakes")
public class EarthquakeController {

    @Autowired
    private EarthquakeService earthquakeService;

    @Operation(summary = "Get recent earthquake anomalies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved earthquake data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<EarthquakeEvent> getRecentEarthquakes() {
        return earthquakeService.getAllRecent();
    }
}
