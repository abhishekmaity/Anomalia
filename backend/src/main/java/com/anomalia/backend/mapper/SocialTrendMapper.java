package com.anomalia.backend.mapper;

import com.anomalia.backend.dto.SocialTrendDTO;
import com.anomalia.backend.model.SocialTrend;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SocialTrendMapper {
    SocialTrendDTO toDTO(SocialTrend entity);
    SocialTrend toEntity(SocialTrendDTO dto);
}
