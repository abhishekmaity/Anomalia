package com.anomalia.backend.controller;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.service.MarketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/market")
@Tag(name = "Market", description = "Stock/crypto market anomaly data")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Operation(summary = "Get recent market anomalies", description = "Returns paginated list of recent market anomalies")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<MarketAnomalyDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return marketService.getRecentEvents(page, size);
    }
}
