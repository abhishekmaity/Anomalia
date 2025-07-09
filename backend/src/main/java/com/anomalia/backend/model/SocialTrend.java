package com.anomalia.backend.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "social_trends")
public class SocialTrend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subreddit;
    private String title;
    private String url; // ✅ now included
    private Instant timestamp;
    private Integer upvotes;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "SocialTrend [id=" + id + ", subreddit=" + subreddit + ", title=" + title + ", url=" + url
                + ", timestamp=" + timestamp + ", upvotes=" + upvotes + "]";
    }

    
}
