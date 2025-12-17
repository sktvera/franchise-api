package com.franquicias.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "branches")
public class Branch {

    @Id
    private String id;

    private String name;

    // relación con Franchise
    private String franchiseId;
}