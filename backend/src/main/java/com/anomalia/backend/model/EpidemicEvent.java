package com.anomalia.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "epidemic_events")
public class EpidemicEvent {

    @Id
    private String id;

    private String diseaseName;
    private String country;
    private int confirmedCases;
    private int deaths;
    private Instant timestamp;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDiseaseName() { return diseaseName; }
    public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getConfirmedCases() { return confirmedCases; }
    public void setConfirmedCases(int confirmedCases) { this.confirmedCases = confirmedCases; }

    public int getDeaths() { return deaths; }
    public void setDeaths(int deaths) { this.deaths = deaths; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
