package com.anomalia.backend.dto;

import java.time.Instant;

public class SocialTrendDTO {
    private String id;
    private String subreddit;
    private String title;
    private String author;
    private int upvotes;
    private Instant timestamp;
    private String url;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SocialTrendDTO [id=" + id + ", subreddit=" + subreddit + ", title=" + title + ", author=" + author
                + ", upvotes=" + upvotes + ", timestamp=" + timestamp + ", url=" + url + "]";
    }


}
