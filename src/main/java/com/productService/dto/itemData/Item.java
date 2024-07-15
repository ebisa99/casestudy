package com.productService.dto.itemData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {
    @JsonProperty("product_description")
    private ProductDescription productDescription;

    @JsonProperty("enrichment")
    private Enrichment enrichment;

    @JsonProperty("product_classification")
    private ProductClassification productClassification;

    @JsonProperty("primary_brand")
    private PrimaryBrand primaryBrand;
}
