package com.productService.productService;

import com.productService.entity.ProductPrice;
import com.productService.repository.ProductPriceRepository;
import com.productService.response.ExternalProductResponse;
import com.productService.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ProductPriceRepository productPriceRepository;
    private final String externalApiUrl = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1";
    private final String key = "3yUxt7WltYG7MFKPp7uyELi1K40ad2ys";

    public ProductPrice saveProductPrice(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    public ProductResponse getProductData(Long tcin){
        ProductResponse productResponse = new ProductResponse();
        String externalUrl = externalApiUrl + "?key="+ key + "&tcin="+ tcin.toString();
        ExternalProductResponse externalProductResponse = restTemplate.getForObject(externalUrl, ExternalProductResponse.class);
        if(externalProductResponse != null && externalProductResponse.getData() != null) {
            productResponse.setId(externalProductResponse.getData().getProduct().getTcin());
            productResponse.setName(externalProductResponse.getData().getProduct().getItem().getProductDescription().getTitle());
            ProductPrice productPrice = productPriceRepository.findById(tcin).orElse(new ProductPrice());
            productResponse.setCurrencyCode(productPrice.getCurrencyCode());
            productResponse.setValue(productPrice.getValue());
        }
        return productResponse;
    }
}
