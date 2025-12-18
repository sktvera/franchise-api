package com.franquicias.api.controller;

import com.franquicias.api.domain.dto.TopProductByBranchResponse;
import com.franquicias.api.service.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
@Tag(
        name = "Franchises",
        description = "Operaciones relacionadas con franquicias"
)
public class FranchiseController {

    private final FranchiseService service;

    @Operation(
            summary = "Obtener el producto con mayor stock por sucursal",
            description = "Retorna el producto con mayor stock por cada sucursal de una franquicia"
    )
    @GetMapping("/{franchiseId}/top-products")
    public Flux<TopProductByBranchResponse> getTopProducts(
            @PathVariable String franchiseId
    ) {
        return service.getTopProductsByFranchise(franchiseId);
    }
}