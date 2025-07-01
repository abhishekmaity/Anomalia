package com.anomalia.backend.repository;

import com.anomalia.backend.model.EarthquakeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarthquakeRepository extends JpaRepository<EarthquakeEvent, String> {
}
