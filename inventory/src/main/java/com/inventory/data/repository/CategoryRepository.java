package com.inventory.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.data.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}