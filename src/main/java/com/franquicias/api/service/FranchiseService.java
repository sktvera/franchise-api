package com.franquicias.api.service;

import com.franquicias.api.domain.dto.TopProductByBranchResponse;
import com.franquicias.api.domain.model.Branch;
import com.franquicias.api.repository.BranchRepository;
import com.franquicias.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FranchiseService {

    private final BranchRepository branchRepository;
    private final ProductRepository productRepository;

    public Flux<TopProductByBranchResponse> getTopProductsByFranchise(String franchiseId) {

        return branchRepository.findByFranchiseId(franchiseId)
                .flatMap(branch ->
                        productRepository
                                .findFirstByBranchIdOrderByStockDesc(branch.getId())
                                .map(product ->
                                        new TopProductByBranchResponse(
                                                branch.getId(),
                                                branch.getName(),
                                                product.getId(),
                                                product.getName(),
                                                product.getStock()
                                        )
                                )
                );
    }
}