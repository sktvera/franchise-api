package com.franquicias.api.service;

import com.franquicias.api.domain.dto.request.CreateProductRequest;
import com.franquicias.api.domain.model.Product;
import com.franquicias.api.exception.BadRequestException;
import com.franquicias.api.exception.NotFoundException;
import com.franquicias.api.repository.BranchRepository;
import com.franquicias.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final BranchRepository branchRepository;

    /**
     * Create a product in a branch
     */
    public Mono<Product> create(CreateProductRequest request) {
        return branchRepository.existsById(request.branchId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new BadRequestException("Branch does not exist"));
                    }

                    Product product = new Product(
                            null,
                            request.name().trim(),
                            request.stock(),
                            request.branchId()
                    );

                    return repository.save(product);
                });
    }

    /**
     * Update product stock
     */
    public Mono<Product> updateStock(String productId, Integer newStock) {
        return repository.findById(productId)
                .switchIfEmpty(Mono.error(new NotFoundException("Product not found")))
                .flatMap(product -> {
                    product.setStock(newStock);
                    return repository.save(product);
                });
    }

    /**
     * Delete product by id
     */
    public Mono<Void> delete(String productId) {
        return repository.existsById(productId)
                .flatMap(exists -> exists
                        ? repository.deleteById(productId)
                        : Mono.error(new NotFoundException("Product not found")));
    }

    /**
     * Get all products by branch
     */
    public Flux<Product> findByBranch(String branchId) {
        return repository.findByBranchId(branchId);
    }

    /**
     * Get product with highest stock in a branch
     */
    public Mono<Product> findTopStockByBranch(String branchId) {
        return repository.findFirstByBranchIdOrderByStockDesc(branchId);
    }
}