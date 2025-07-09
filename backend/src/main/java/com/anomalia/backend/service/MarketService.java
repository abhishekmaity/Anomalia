package com.anomalia.backend.service;

import com.anomalia.backend.dto.MarketAnomalyDTO;
import com.anomalia.backend.mapper.MarketMapper;
import com.anomalia.backend.repository.MarketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    private final MarketRepository repository;
    private final MarketMapper mapper;

    public MarketService(MarketRepository repository, MarketMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<MarketAnomalyDTO> getRecentAnomalies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return repository.findAll(pageable).map(mapper::toDTO);
    }
}
