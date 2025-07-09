package com.anomalia.backend.dto;

import java.time.LocalDate;

public class MarketAnomalyDTO {
    private Long id;
    private String ticker;
    private LocalDate date;
    private Double price;
    private Double anomalyScore;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTicker() {
        return ticker;
    }
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getAnomalyScore() {
        return anomalyScore;
    }
    public void setAnomalyScore(Double anomalyScore) {
        this.anomalyScore = anomalyScore;
    }

    @Override
    public String toString() {
        return "MarketAnomalyDTO [id=" + id + ", ticker=" + ticker + ", date=" + date + ", price=" + price
                + ", anomalyScore=" + anomalyScore + "]";
    }


}
