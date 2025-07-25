package com.anomalia.backend.repository;

import com.anomalia.backend.model.MarketAnomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<MarketAnomaly, String> {
}
