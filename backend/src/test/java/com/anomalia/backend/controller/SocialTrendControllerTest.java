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

import java.time.Instant;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SocialTrendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialTrendService socialTrendService;

    @Test
    void getRecentReturnsPage() throws Exception {
        SocialTrendDTO dto = new SocialTrendDTO();
        dto.setId("r-12345");
        dto.setSubreddit("technology");
        dto.setTitle("AI is transforming healthcare");
        dto.setAuthor("reddit_user");
        dto.setUpvotes(921);
        dto.setTimestamp(Instant.now());
        dto.setUrl("https://reddit.com/r/technology/abc123");

        Page<SocialTrendDTO> page = new PageImpl<>(List.of(dto));
        when(socialTrendService.getRecentTrends(0, 10)).thenReturn(page);

        mockMvc.perform(get("/api/social/recent")
                        .param("page", "0").param("size", "10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].subreddit").value("technology"));
    }
}
