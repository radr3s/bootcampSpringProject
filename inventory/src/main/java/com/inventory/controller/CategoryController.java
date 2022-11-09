package com.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.business.dto.CategoryDto;
import com.inventory.business.service.CategoryService;

@RestController()
@RequestMapping("/inventory")
public class CategoryController {

	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public List<CategoryDto> getCategories(){
		return categoryService.getCategories();
	}
}
