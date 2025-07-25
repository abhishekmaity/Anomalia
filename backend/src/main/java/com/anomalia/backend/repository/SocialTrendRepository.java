package com.anomalia.backend.repository;

import com.anomalia.backend.model.SocialTrend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialTrendRepository extends JpaRepository<SocialTrend, Long> {
}
