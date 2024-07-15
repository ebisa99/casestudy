package com.productService.dto.itemData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDescription {
    private String title;

    @JsonProperty("downstream_description")
    private String downstreamDescription;
}
