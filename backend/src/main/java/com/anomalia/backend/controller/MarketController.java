package com.anomalia.backend.controller;

import com.anomalia.backend.model.MarketAnomaly;
import com.anomalia.backend.service.MarketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markets")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Operation(summary = "Get recent market anomalies")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved market data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<MarketAnomaly> getMarketAnomalies() {
        return marketService.getAllRecent();
    }
}
