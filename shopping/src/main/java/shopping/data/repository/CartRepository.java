package shopping.data.repository;

import org.springframework.data.repository.CrudRepository;

import shopping.data.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

}