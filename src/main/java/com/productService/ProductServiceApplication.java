package com.productService;

import com.productService.entity.ProductPrice;
import com.productService.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ProductPrice productPrice = new ProductPrice();
		productPrice.setId(13860428L);
		productPrice.setValue(100.0);
		productPrice.setCurrencyCode("USD");

		productService.saveProductPrice(productPrice);
		System.out.println("ProductPrice saved successfully");
	}

}
