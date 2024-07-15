package com.productService.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Double value;
    private String currencyCode;
}
