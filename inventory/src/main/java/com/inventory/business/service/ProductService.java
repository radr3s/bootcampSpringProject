package com.inventory.business.service;

import java.util.List;

import com.inventory.business.dto.CategoryDto;
import com.inventory.business.dto.ProductDto;


public interface ProductService {
	public List<ProductDto> getProductsWithCategoryId(long categoryId);
	public ProductDto getProduct(long id);
}
