package com.anomalia.backend.repository;

import com.anomalia.backend.model.WeatherAnomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherAnomaly, String> {
}
