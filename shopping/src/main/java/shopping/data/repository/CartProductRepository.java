package shopping.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import shopping.data.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Long>{

	Optional<List<CartProduct>> findByCartId(long cartId);
}
