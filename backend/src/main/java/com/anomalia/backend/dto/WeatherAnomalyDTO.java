package com.anomalia.backend.dto;

import java.time.LocalDateTime;

public class WeatherAnomalyDTO {
    private String city;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Double windSpeed;
    private LocalDateTime recordedAt;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Double getTemperature() {
        return temperature;
    }
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    public Double getHumidity() {
        return humidity;
    }
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
    public Double getPressure() {
        return pressure;
    }
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
    public Double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }
    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
    @Override
    public String toString() {
        return "WeatherAnomalyDTO [city=" + city + ", temperature=" + temperature + ", humidity=" + humidity
                + ", pressure=" + pressure + ", windSpeed=" + windSpeed + ", recordedAt=" + recordedAt + "]";
    }

    
}
