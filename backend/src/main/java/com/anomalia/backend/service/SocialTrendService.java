package com.anomalia.backend.service;

import com.anomalia.backend.dto.SocialTrendDTO;
import com.anomalia.backend.mapper.SocialTrendMapper;
import com.anomalia.backend.repository.SocialTrendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class SocialTrendService {

    private final SocialTrendRepository repository;
    private final SocialTrendMapper mapper;

    @Autowired
    public SocialTrendService(SocialTrendRepository repository, SocialTrendMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<SocialTrendDTO> getTrendingPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return repository.findAll(pageable).map(mapper::toDTO);
    }
}
