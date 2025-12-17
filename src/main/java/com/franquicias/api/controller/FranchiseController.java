package com.franquicias.api.controller;

import com.franquicias.api.domain.model.Franchise;
import com.franquicias.api.service.FranchiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franchises")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService service;

    @GetMapping
    public Flux<Franchise> getAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Franchise> create(@RequestBody Franchise franchise) {
        return service.create(franchise);
    }
}