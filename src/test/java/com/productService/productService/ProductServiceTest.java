package com.productService.productService;

import com.productService.dto.itemData.Data;
import com.productService.dto.itemData.Item;
import com.productService.dto.itemData.ProductDescription;
import com.productService.dto.product.Product;
import com.productService.entity.ProductPrice;
import com.productService.repository.ProductPriceRepository;
import com.productService.response.ExternalProductResponse;
import com.productService.response.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ProductPriceRepository productPriceRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveProductPrice() {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setId(1L);
        productPrice.setValue(100.0);
        productPrice.setCurrencyCode("USD");

        when(productPriceRepository.save(productPrice)).thenReturn(productPrice);

        ProductPrice savedProductPrice = productService.saveProductPrice(productPrice);

        assertEquals(productPrice.getId(), savedProductPrice.getId());
        assertEquals(productPrice.getValue(), savedProductPrice.getValue());
        assertEquals(productPrice.getCurrencyCode(), savedProductPrice.getCurrencyCode());
    }

    @Test
    public void testGetProductData() {
        Long tcin = 12345L;
        String externalUrl = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin=12345";

        ExternalProductResponse externalProductResponse = new ExternalProductResponse();
        Data data = new Data();
        Product product = new Product();
        Item item = new Item();
        ProductDescription productDescription = new ProductDescription();

        productDescription.setTitle("Sample Product");
        item.setProductDescription(productDescription);
        product.setTcin(tcin);
        product.setItem(item);
        data.setProduct(product);
        externalProductResponse.setData(data);

        when(restTemplate.getForObject(externalUrl, ExternalProductResponse.class)).thenReturn(externalProductResponse);

        ProductPrice productPrice = new ProductPrice();
        productPrice.setId(tcin);
        productPrice.setValue(100.0);
        productPrice.setCurrencyCode("USD");

        when(productPriceRepository.findById(tcin)).thenReturn(Optional.of(productPrice));

        ProductResponse productResponse = productService.getProductData(tcin);

        assertEquals(tcin, productResponse.getId());
        assertEquals("Sample Product", productResponse.getName());
        assertEquals("USD", productResponse.getCurrencyCode());
        assertEquals(100.0, productResponse.getValue());
    }
}