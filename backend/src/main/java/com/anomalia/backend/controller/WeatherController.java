package com.anomalia.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anomalia.backend.dto.WeatherAnomalyDTO;
import com.anomalia.backend.service.WeatherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @Operation(summary = "Get recent weather anomalies", description = "Returns a paginated list of recent weather anomaly records")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved weather anomalies")
    @GetMapping("/recent")
    public Page<WeatherAnomalyDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return service.getRecentAnomalies(page, size);
    }
}
