package shopping.business.service;

import java.util.List;
import java.util.Optional;

import shopping.business.dto.CartDto;
import shopping.business.dto.CartProductDto;
import shopping.data.entity.Cart;


public interface CartService {

	CartDto addProduct(CartProductDto cartProductDto);

	void updateCardCartStatus(long cartId, boolean checkout);

	void removeProductFromCart(long cartId, long productId);

	CartDto createCard(String customerName);

	Cart findCard(Long cartId);
	
	CartDto findCardWithCardProduct(Long cartId);

}
