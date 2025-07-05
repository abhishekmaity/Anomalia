package com.anomalia.backend.controller;

import com.anomalia.backend.model.EpidemicEvent;
import com.anomalia.backend.service.EpidemicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epidemics")
public class EpidemicController {

    @Autowired
    private EpidemicService epidemicService;

    @Operation(summary = "Get recent epidemic outbreaks")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved epidemic data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<EpidemicEvent> getEpidemicEvents() {
        return epidemicService.getAllRecent();
    }
}
