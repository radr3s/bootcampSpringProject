package com.inventory.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inventory.business.dto.CategoryDto;
import com.inventory.business.dto.ProductDto;
import com.inventory.data.entity.Category;
import com.inventory.data.entity.Product;
import com.inventory.data.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<ProductDto> getProductsWithCategoryId(long categoryId) {
		List<ProductDto> productsDto = new ArrayList<ProductDto>();
		Optional<List<Product>> productsOpt = productRepository.findAllByCategoryId(categoryId);
		if (productsOpt.isPresent()) {
			List<Product> products = productsOpt.get();
			products.forEach((p) -> productsDto.add(productEntityToProductDto(p)));
		}
		return productsDto;
	}

	@Override
	public ProductDto getProduct(long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if (productOpt.isPresent()) {
			Product product = productOpt.get();
			ProductDto productDto = productEntityToProductDto(product);
			return productDto;
		}
		return null;
	}
	
	public ProductDto productEntityToProductDto(Product product) {	
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());
		return productDto;
	}
}
