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
@RequestMapping("/api/social")
@Tag(name = "Social Trends", description = "Top Reddit trends by subreddit")
public class SocialTrendController {

    @Autowired
    private SocialTrendService socialTrendService;

    @Operation(summary = "Get top Reddit posts", description = "Returns paginated list of trending Reddit posts by subreddit")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/recent")
    public Page<SocialTrendDTO> getRecent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return socialTrendService.getRecentTrends(page, size);
    }
}
