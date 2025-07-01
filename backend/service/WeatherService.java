package com.anomalia.backend.service;

import com.anomalia.backend.model.WeatherAnomaly;
import com.anomalia.backend.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository repository;

    @Autowired
    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public List<WeatherAnomaly> getAllRecent() {
        return repository.findAll();
    }

    public void save(WeatherAnomaly anomaly) {
        repository.save(anomaly);
    }
}
