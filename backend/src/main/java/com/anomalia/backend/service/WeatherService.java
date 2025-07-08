package com.anomalia.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anomalia.backend.dto.WeatherAnomalyDTO;
import com.anomalia.backend.mapper.WeatherMapper;
import com.anomalia.backend.repository.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository repository;

    public Page<WeatherAnomalyDTO> getRecentAnomalies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("recordedAt").descending());
        return repository.findAll(pageable).map(WeatherMapper::toDTO);
    }
}
