package com.anomalia.backend.service;

import com.anomalia.backend.dto.WeatherAnomalyDTO;
import com.anomalia.backend.mapper.WeatherMapper;
import com.anomalia.backend.model.WeatherAnomaly;
import com.anomalia.backend.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherRepository repository;
    private final WeatherMapper weatherMapper;

    @Autowired
    public WeatherService(WeatherRepository repository, WeatherMapper weatherMapper) {
        this.repository = repository;
        this.weatherMapper = weatherMapper;
    }

    public Page<WeatherAnomalyDTO> getRecentAnomalies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("recordedAt").descending());
        Page<WeatherAnomaly> anomalies = repository.findAll(pageable);
        return anomalies.map(weatherMapper::toDTO);
    }
}
