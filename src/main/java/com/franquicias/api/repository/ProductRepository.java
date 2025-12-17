package com.franquicias.api.repository;

import com.franquicias.api.domain.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository
        extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findByBranchId(String branchId);

    Mono<Product> findFirstByBranchIdOrderByStockDesc(String branchId);
}