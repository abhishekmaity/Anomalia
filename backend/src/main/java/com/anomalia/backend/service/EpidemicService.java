package com.anomalia.backend.service;

import com.anomalia.backend.dto.EpidemicEventDTO;
import com.anomalia.backend.mapper.EpidemicMapper;
import com.anomalia.backend.repository.EpidemicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EpidemicService {

    private final EpidemicRepository repository;
    private final EpidemicMapper mapper;

    @Autowired
    public EpidemicService(EpidemicRepository repository, EpidemicMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<EpidemicEventDTO> getRecentEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return repository.findAll(pageable).map(mapper::toDTO);
    }
}
