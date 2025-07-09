package com.anomalia.backend.mapper;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.model.MarketAnomaly;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarketMapper {
    MarketAnomalyDTO toDTO(MarketAnomaly anomaly);
    MarketAnomaly toEntity(MarketAnomalyDTO dto);
}
