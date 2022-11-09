package com.inventory.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.inventory.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	Optional<List<Product>> findAllByCategoryId(long categoryId);

}
