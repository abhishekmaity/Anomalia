package com.anomalia.backend.dto;

import java.time.LocalDate;

public class MarketAnomalyDTO {
    private Long id;
    private String ticker;
    private LocalDate date;
    private Double price;
    private Double anomalyScore;

    // Getters and Setters
}
