package com.productService.entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "productPrices")
public class ProductPrice {
    @Id
    private Long id;
    private Double value;
    private String currencyCode;
}
