package com.franquicias.api.service;

import com.franquicias.api.domain.model.Branch;
import com.franquicias.api.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository repository;

    public Mono<Branch> create(Branch branch) {
        return repository.save(branch);
    }

    public Flux<Branch> findByFranchise(String franchiseId) {
        return repository.findByFranchiseId(franchiseId);
    }
}