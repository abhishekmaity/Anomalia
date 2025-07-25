package com.anomalia.backend.service;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.mapper.MarketMapper;
import com.anomalia.backend.repository.MarketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    private final MarketRepository repository;
    private final MarketMapper mapper;

    @Autowired
    public MarketService(MarketRepository repository, MarketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<MarketAnomalyDTO> getRecentEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return repository.findAll(pageable).map(mapper::toDTO);
    }
}
