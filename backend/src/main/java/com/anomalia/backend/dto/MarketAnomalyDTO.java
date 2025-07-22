package com.anomalia.backend.dto;

import java.time.Instant;

public class MarketAnomalyDTO {
    private String id;
    private String symbol;
    private Double price;
    private String exchange;
    private Instant timestamp;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MarketAnomalyDTO [id=" + id + ", symbol=" + symbol + ", price=" + price + ", exchange=" + exchange
                + ", timestamp=" + timestamp + "]";
    }

    
}
