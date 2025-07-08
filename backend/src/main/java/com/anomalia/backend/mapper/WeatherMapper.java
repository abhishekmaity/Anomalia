package com.anomalia.backend.mapper;

import com.anomalia.backend.dto.WeatherAnomalyDTO;
import com.anomalia.backend.model.WeatherAnomaly;

public class WeatherMapper {

    public static WeatherAnomalyDTO toDTO(WeatherAnomaly entity) {
        WeatherAnomalyDTO dto = new WeatherAnomalyDTO();
        dto.setCity(entity.getCity());
        dto.setTemperature(entity.getTemperature());
        dto.setHumidity(entity.getHumidity());
        dto.setPressure(entity.getPressure());
        dto.setWindSpeed(entity.getWindSpeed());
        dto.setRecordedAt(entity.getRecordedAt());
        return dto;
    }
}
