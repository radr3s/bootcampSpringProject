package com.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.business.dto.CategoryDto;
import com.inventory.business.dto.ProductDto;
import com.inventory.business.service.ProductService;

@RestController()
@RequestMapping("/inventory")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService = productService;
	}
	
	@GetMapping("/products/{categoryId}")
	public List<ProductDto> getProductsWithCategoryId(@PathVariable("categoryId") long categoryId){
		List<ProductDto> productsDto = productService.getProductsWithCategoryId(categoryId);
		return productsDto;
	}
	
	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long id) {
		ProductDto productDto = productService.getProduct(id);
		return productDto;
	}
}
