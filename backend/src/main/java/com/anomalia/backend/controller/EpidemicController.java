package com.anomalia.backend.controller;

import com.anomalia.backend.dto.EpidemicEventDTO;
import com.anomalia.backend.service.EpidemicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/epidemics")
@Tag(name = "Epidemics", description = "Health anomaly data")
public class EpidemicController {

    @Autowired
    private EpidemicService epidemicService;

    @Operation(summary = "Get recent health events", description = "Returns paginated list of recent health indicators by country")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<EpidemicEventDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return epidemicService.getRecentEvents(page, size);
    }
}
