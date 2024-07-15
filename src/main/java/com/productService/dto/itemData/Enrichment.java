package com.productService.dto.itemData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Enrichment {
    @JsonProperty("images")
    private Image image;
}
