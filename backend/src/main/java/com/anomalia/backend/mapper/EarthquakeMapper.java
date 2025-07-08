package com.anomalia.backend.mapper;

import org.mapstruct.Mapper;

import com.anomalia.backend.dto.EarthquakeEventDTO;
import com.anomalia.backend.model.EarthquakeEvent;

@Mapper(componentModel = "spring")
public interface EarthquakeMapper {
    EarthquakeEventDTO toDTO(EarthquakeEvent event);
    EarthquakeEvent toEntity(EarthquakeEventDTO dto);
}
 
