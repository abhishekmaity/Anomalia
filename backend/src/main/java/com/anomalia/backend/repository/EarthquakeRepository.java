package com.anomalia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anomalia.backend.model.EarthquakeEvent;

@Repository
public interface EarthquakeRepository extends JpaRepository<EarthquakeEvent, String> {
}
