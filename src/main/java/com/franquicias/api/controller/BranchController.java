package com.franquicias.api.controller;

import com.franquicias.api.domain.model.Branch;
import com.franquicias.api.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
@Tag(name = "Branches", description = "Gestión de sucursales")
public class BranchController {

    private final BranchService service;

    @Operation(summary = "Crear una sucursal")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Branch> create(@RequestBody Branch branch) {
        return service.create(branch);
    }

    @Operation(summary = "Listar sucursales por franquicia")
    @GetMapping("/franchise/{franchiseId}")
    public Flux<Branch> getByFranchise(@PathVariable String franchiseId) {
        return service.findByFranchise(franchiseId);
    }
}