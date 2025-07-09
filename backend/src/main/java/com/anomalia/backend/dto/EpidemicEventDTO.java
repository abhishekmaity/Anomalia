package com.anomalia.backend.dto;

import java.time.LocalDate;

public class EpidemicEventDTO {
    private Long id;
    private String indicator;
    private String country;
    private LocalDate date;
    private Double value;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIndicator() {
        return indicator;
    }
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "EpidemicEventDTO [id=" + id + ", indicator=" + indicator + ", country=" + country + ", date=" + date
                + ", value=" + value + "]";
    }

    
}
