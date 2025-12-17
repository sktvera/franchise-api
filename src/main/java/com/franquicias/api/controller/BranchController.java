package com.franquicias.api.controller;

import com.franquicias.api.domain.model.Branch;
import com.franquicias.api.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Branch> create(@RequestBody Branch branch) {
        return service.create(branch);
    }

    @GetMapping("/franchise/{franchiseId}")
    public Flux<Branch> getByFranchise(@PathVariable String franchiseId) {
        return service.findByFranchise(franchiseId);
    }
}