package com.franquicias.api.service;

import com.franquicias.api.domain.model.Product;
import com.franquicias.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Mono<Product> create(Product product) {
        return repository.save(product);
    }

    public Mono<Void> delete(String productId) {
        return repository.deleteById(productId);
    }

    public Mono<Product> updateStock(String productId, Integer newStock) {
        return repository.findById(productId)
                .flatMap(product -> {
                    product.setStock(newStock);
                    return repository.save(product);
                });
    }

    public Flux<Product> findByBranch(String branchId) {
        return repository.findByBranchId(branchId);
    }

    public Mono<Product> findTopStockByBranch(String branchId) {
        return repository.findFirstByBranchIdOrderByStockDesc(branchId);
    }
}