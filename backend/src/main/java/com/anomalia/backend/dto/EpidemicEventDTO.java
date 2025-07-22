package com.anomalia.backend.dto;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EpidemicEventDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String diseaseName;
    private String country;
    private int confirmedCases;
    private int deaths;
    private Instant timestamp;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDiseaseName() {
        return diseaseName;
    }
    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getConfirmedCases() {
        return confirmedCases;
    }
    public void setConfirmedCases(int confirmedCases) {
        this.confirmedCases = confirmedCases;
    }
    public int getDeaths() {
        return deaths;
    }
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "EpidemicEventDTO [id=" + id + ", diseaseName=" + diseaseName + ", country=" + country
                + ", confirmedCases=" + confirmedCases + ", deaths=" + deaths + ", timestamp=" + timestamp + "]";
    }
      
    
}
