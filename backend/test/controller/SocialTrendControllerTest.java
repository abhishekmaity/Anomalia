package com.anomalia.backend.controller;

import com.anomalia.backend.model.SocialTrend;
import com.anomalia.backend.service.SocialTrendService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(SocialTrendController.class)
public class SocialTrendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialTrendService socialTrendService;

    @Test
    public void testGetSocialTrends() throws Exception {
        SocialTrend t = new SocialTrend();
        t.setId("s-001");
        t.setSubreddit("r/science");
        t.setTitle("NASA discovers new particle stream");
        t.setUpvotes(5200);
        t.setTimestamp(Instant.now());

        Mockito.when(socialTrendService.getAllRecent()).thenReturn(List.of(t));

        mockMvc.perform(get("/api/social-trends"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value("s-001"))
                .andExpect(jsonPath("$[0].subreddit").value("r/science"));
    }
}
