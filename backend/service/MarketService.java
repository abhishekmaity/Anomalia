package com.anomalia.backend.service;

import com.anomalia.backend.model.MarketAnomaly;
import com.anomalia.backend.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository repository;

    @Autowired
    public MarketService(MarketRepository repository) {
        this.repository = repository;
    }

    public List<MarketAnomaly> getAllRecent() {
        return repository.findAll();
    }

    public void save(MarketAnomaly anomaly) {
        repository.save(anomaly);
    }
}
