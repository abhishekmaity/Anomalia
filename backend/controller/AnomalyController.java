package com.anomalia.backend.controller;

import com.anomalia.backend.model.*;
import com.anomalia.backend.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anomalies")
public class AnomalyController {

    @Autowired private EarthquakeService earthquakeService;
    @Autowired private WeatherAnomalyService weatherService;
    @Autowired private EpidemicService epidemicService;
    @Autowired private MarketAnomalyService marketService;
    @Autowired private SocialTrendService socialService;

    @Operation(summary = "Get recent earthquake anomalies")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/earthquakes")
    public List<EarthquakeEvent> getRecentEarthquakes() {
        return earthquakeService.getAllRecent();
    }

    @Operation(summary = "Get recent weather anomalies")
    @GetMapping("/weather")
    public List<WeatherAnomaly> getWeatherAnomalies() {
        return weatherService.getAllRecent();
    }

    @Operation(summary = "Get recent epidemic outbreaks")
    @GetMapping("/epidemics")
    public List<EpidemicEvent> getEpidemicEvents() {
        return epidemicService.getAllRecent();
    }

    @Operation(summary = "Get recent market anomalies")
    @GetMapping("/markets")
    public List<MarketAnomaly> getMarketAnomalies() {
        return marketService.getAllRecent();
    }

    @Operation(summary = "Get recent social trend anomalies")
    @GetMapping("/social")
    public List<SocialTrendAnomaly> getSocialTrends() {
        return socialService.getAllRecent();
    }
}
