package com.commerce.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.commerce.business.dto.CartDto;
import com.commerce.business.dto.ProductDto;

@Component
public class InventoryServiceClient {

	public ProductDto getProduct(long productId) {
		String url = "http://localhost:8081/inventory/product/" + productId;
		RestTemplate  restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;	
	}
}
