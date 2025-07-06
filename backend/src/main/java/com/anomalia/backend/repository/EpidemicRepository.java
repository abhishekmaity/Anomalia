package com.anomalia.backend.repository;

import com.anomalia.backend.model.EpidemicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpidemicRepository extends JpaRepository<EpidemicEvent, String> {
}
