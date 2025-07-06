package com.anomalia.backend.service;

import com.anomalia.backend.model.SocialTrend;
import com.anomalia.backend.repository.SocialTrendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialTrendService {

    private final SocialTrendRepository repository;

    public SocialTrendService(SocialTrendRepository repository) {
        this.repository = repository;
    }

    public List<SocialTrend> getAllRecent() {
        return repository.findAll();
    }

    public void save(SocialTrend trend) {
        repository.save(trend);
    }
}
