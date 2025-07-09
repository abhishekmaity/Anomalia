package com.anomalia.backend.mapper;

import com.anomalia.backend.dto.EpidemicEventDTO;
import com.anomalia.backend.model.EpidemicEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpidemicMapper {
    EpidemicEventDTO toDTO(EpidemicEvent event);
    EpidemicEvent toEntity(EpidemicEventDTO dto);
}
