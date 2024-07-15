package com.productService.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.productService.dto.itemData.Item;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long tcin;
    private Item item;
}
