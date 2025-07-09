package com.anomalia.backend.controller;

import com.anomalia.backend.dto.SocialTrendDTO;
import com.anomalia.backend.service.SocialTrendService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/social-trends")
@Tag(name = "SocialTrends", description = "Reddit anomaly data")
public class SocialTrendController {

    @Autowired
    private SocialTrendService trendService;

    @Operation(summary = "Get trending Reddit posts", description = "Returns a paginated list of trending Reddit anomalies")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<SocialTrendDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return trendService.getTrendingPosts(page, size);
    }
}
