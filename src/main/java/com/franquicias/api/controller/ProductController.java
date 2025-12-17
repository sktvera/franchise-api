package com.franquicias.api.controller;

import com.franquicias.api.domain.model.Product;
import com.franquicias.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(@RequestBody Product product) {
        return service.create(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @PatchMapping("/{id}/stock")
    public Mono<Product> updateStock(
            @PathVariable String id,
            @RequestParam Integer stock
    ) {
        return service.updateStock(id, stock);
    }

    @GetMapping("/branch/{branchId}")
    public Flux<Product> getByBranch(@PathVariable String branchId) {
        return service.findByBranch(branchId);
    }
}