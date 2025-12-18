package com.franquicias.api.controller;

import com.franquicias.api.domain.dto.request.CreateProductRequest;
import com.franquicias.api.domain.dto.request.UpdateStockRequest;
import com.franquicias.api.domain.model.Product;
import com.franquicias.api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Gestión de productos")
public class ProductController {

    private final ProductService service;

    @Operation(summary = "Crear un producto en una sucursal")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> create(@Valid @RequestBody CreateProductRequest request) {
        return service.create(request);
    }

    @Operation(summary = "Eliminar un producto por ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @Operation(summary = "Actualizar stock de un producto")
    @PatchMapping("/{id}/stock")
    public Mono<Product> updateStock(
            @PathVariable String id,
            @Valid @RequestBody UpdateStockRequest body
    ) {
        return service.updateStock(id, body.stock());
    }

    @Operation(summary = "Listar productos por sucursal")
    @GetMapping("/branch/{branchId}")
    public Flux<Product> getByBranch(@PathVariable String branchId) {
        return service.findByBranch(branchId);
    }
}