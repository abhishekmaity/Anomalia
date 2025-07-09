package com.anomalia.backend.dto;

import java.time.LocalDateTime;

public class SocialTrendDTO {
    private Long id;
    private String subreddit;
    private String title;
    private String url;
    private LocalDateTime timestamp;
    private Integer upvotes;
    
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
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
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
        return "SocialTrendDTO [id=" + id + ", subreddit=" + subreddit + ", title=" + title + ", url=" + url
                + ", timestamp=" + timestamp + ", upvotes=" + upvotes + "]";
    }

}
