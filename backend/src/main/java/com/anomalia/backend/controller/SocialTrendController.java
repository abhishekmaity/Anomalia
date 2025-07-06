package com.anomalia.backend.controller;

import com.anomalia.backend.model.SocialTrend;
import com.anomalia.backend.service.SocialTrendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-trends")
public class SocialTrendController {

    @Autowired
    private SocialTrendService socialTrendService;

    @Operation(summary = "Get recent Reddit trends")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved Reddit data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<SocialTrend> getSocialTrends() {
        return socialTrendService.getAllRecent();
    }
}
