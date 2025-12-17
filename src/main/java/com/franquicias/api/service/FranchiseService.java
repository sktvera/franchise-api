package com.franquicias.api.service;

import com.franquicias.api.domain.model.Franchise;
import com.franquicias.api.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final FranchiseRepository repository;

    public Flux<Franchise> findAll() {
        return repository.findAll();
    }

    public Mono<Franchise> create(Franchise franchise) {
        return repository.save(franchise);
    }
}