package com.anomalia.backend.mapper;

import com.anomalia.backend.dto.SocialTrendDTO;
import com.anomalia.backend.model.SocialTrend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface SocialTrendMapper {

    @Mappings({
        @Mapping(source = "timestamp", target = "timestamp")
    })
    SocialTrendDTO toDTO(SocialTrend entity);

    SocialTrend toEntity(SocialTrendDTO dto);

    // Conversion: Instant → LocalDateTime
    default LocalDateTime map(Instant value) {
        return value == null ? null : value.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    // Optional: LocalDateTime → Instant
    default Instant map(LocalDateTime value) {
        return value == null ? null : value.atZone(ZoneId.systemDefault()).toInstant();
    }
}
