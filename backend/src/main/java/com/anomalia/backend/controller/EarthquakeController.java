package com.anomalia.backend.controller;

import com.anomalia.backend.dto.EarthquakeEventDTO;
import com.anomalia.backend.service.EarthquakeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/earthquakes")
@Tag(name = "Earthquakes", description = "Earthquake anomaly data")
public class EarthquakeController {

    @Autowired
    private EarthquakeService earthquakeService;

    @Operation(summary = "Get recent earthquake events", description = "Returns paginated list of recent earthquakes")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<EarthquakeEventDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return earthquakeService.getRecentEvents(page, size);
    }
}
