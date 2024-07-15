package com.productService.repository;

import com.productService.entity.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductPriceRepository extends MongoRepository<ProductPrice, Long> {
}
