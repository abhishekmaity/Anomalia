package com.anomalia.backend.dto;

import java.time.LocalDateTime;

public class EarthquakeEventDTO {
    private Long id;
    private String location;
    private Double magnitude;
    private Double depth;
    private LocalDateTime time;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Double getMagnitude() {
        return magnitude;
    }
    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }
    public Double getDepth() {
        return depth;
    }
    public void setDepth(Double depth) {
        this.depth = depth;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "EarthquakeEventDTO [id=" + id + ", location=" + location + ", magnitude=" + magnitude + ", depth="
                + depth + ", time=" + time + "]";
    }

    
}
