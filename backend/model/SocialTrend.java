// 📁 File: model/SocialTrend.java
package com.anomalia.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "social_trends")
public class SocialTrend {

    @Id
    private String id;
    private String subreddit;
    private String title;
    private int upvotes;
    private Instant timestamp;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSubreddit() { return subreddit; }
    public void setSubreddit(String subreddit) { this.subreddit = subreddit; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getUpvotes() { return upvotes; }
    public void setUpvotes(int upvotes) { this.upvotes = upvotes; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
