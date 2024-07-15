package com.productService.dto.itemData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductClassification {
    @JsonProperty("product_type_name")
    private String productTypeName;

    @JsonProperty("merchandise_type_name")
    private String merchandiseTypeName;
}
