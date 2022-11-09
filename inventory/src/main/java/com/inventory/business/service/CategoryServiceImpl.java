package com.inventory.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.business.dto.CategoryDto;
import com.inventory.data.entity.Category;
import com.inventory.data.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<CategoryDto> getCategories() {
		List<CategoryDto> categoriesDto = new ArrayList<CategoryDto>();
		Iterable<Category> categories =  categoryRepository.findAll();
		categories.forEach((c) -> categoriesDto.add(categoriesEntityToCategoryDto(c))); 
		return categoriesDto;		
	}
	
	public CategoryDto categoriesEntityToCategoryDto(Category category){
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}
}
