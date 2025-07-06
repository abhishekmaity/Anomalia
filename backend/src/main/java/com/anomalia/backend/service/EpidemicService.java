package com.anomalia.backend.service;

import com.anomalia.backend.model.EpidemicEvent;
import com.anomalia.backend.repository.EpidemicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpidemicService {

    private final EpidemicRepository repository;

    public EpidemicService(EpidemicRepository repository) {
        this.repository = repository;
    }

    public List<EpidemicEvent> getAllRecent() {
        return repository.findAll();
    }

    public void save(EpidemicEvent event) {
        repository.save(event);
    }
}
