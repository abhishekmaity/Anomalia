package com.anomalia.backend.controller;

import com.anomalia.backend.dto.SocialTrendDTO;
import com.anomalia.backend.service.SocialTrendService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SocialTrendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialTrendService trendService;

    @Test
    void getRecentTrends() throws Exception {
        SocialTrendDTO dto = new SocialTrendDTO();
        dto.setSubreddit("r/technology");
        dto.setTitle("AI breakthrough!");
        dto.setUrl("https://reddit.com/post/ai-breakthrough");
        dto.setUpvotes(1530);
        dto.setTimestamp(LocalDateTime.now());

        Page<SocialTrendDTO> page = new PageImpl<>(List.of(dto));
        when(trendService.getTrendingPosts(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/social-trends/recent")
                        .param("page", "0")
                        .param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].subreddit").value("r/technology"));
    }
}
