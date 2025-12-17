package com.franquicias.api.repository;

import com.franquicias.api.domain.model.Branch;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BranchRepository
        extends ReactiveMongoRepository<Branch, String> {

    Flux<Branch> findByFranchiseId(String franchiseId);
}