package com.anomalia.backend.service;

import com.anomalia.backend.model.EarthquakeEvent;
import com.anomalia.backend.repository.EarthquakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarthquakeService {

    private final EarthquakeRepository repository;

    public EarthquakeService(EarthquakeRepository repository) {
        this.repository = repository;
    }

    public List<EarthquakeEvent> getAllRecent() {
        return repository.findAll();
    }

    public void save(EarthquakeEvent event) {
        repository.save(event);
    }
}
