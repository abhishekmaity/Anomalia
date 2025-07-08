package com.anomalia.backend.mapper;

import org.mapstruct.Mapper;

import com.anomalia.backend.dto.WeatherAnomalyDTO;
import com.anomalia.backend.model.WeatherAnomaly;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
    WeatherAnomalyDTO toDTO(WeatherAnomaly entity);
    WeatherAnomaly toEntity(WeatherAnomalyDTO dto);
}
