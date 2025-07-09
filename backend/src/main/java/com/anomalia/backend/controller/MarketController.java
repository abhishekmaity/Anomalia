package com.anomalia.backend.controller;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.service.MarketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/markets")
@Tag(name = "Markets", description = "Financial anomaly data")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Operation(summary = "Get recent market anomalies", description = "Returns paginated list of market anomaly events")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<MarketAnomalyDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return marketService.getRecentAnomalies(page, size);
    }
}
