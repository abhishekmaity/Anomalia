package com.anomalia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anomalia.backend.model.WeatherAnomaly;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherAnomaly, Long> {
}
