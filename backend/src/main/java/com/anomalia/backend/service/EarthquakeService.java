package com.anomalia.backend.service;

import com.anomalia.backend.dto.EarthquakeEventDTO;
import com.anomalia.backend.mapper.EarthquakeMapper;
import com.anomalia.backend.repository.EarthquakeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EarthquakeService {

    private final EarthquakeRepository repository;
    private final EarthquakeMapper mapper;

    @Autowired
    public EarthquakeService(EarthquakeRepository repository, EarthquakeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<EarthquakeEventDTO> getRecentEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return repository.findAll(pageable).map(mapper::toDTO);
    }
}
