package com.franquicias.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopProductByBranchResponse {

    private String branchId;
    private String branchName;

    private String productId;
    private String productName;
    private Integer stock;
}