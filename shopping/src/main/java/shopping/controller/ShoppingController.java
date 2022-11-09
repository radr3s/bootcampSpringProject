package shopping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.business.dto.CartDto;
import shopping.business.dto.CartProductDto;
import shopping.business.service.CartService;

@RestController()
@RequestMapping("/shopping")
public class ShoppingController {

	private CartService cartService;

	public ShoppingController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/cart/create/{customerName}")
	public CartDto createCart(@PathVariable String customerName) {
		CartDto cartDto = cartService.createCard(customerName);
		return cartDto;
	}

	@PostMapping("/cart/add")
	public void addProduct(@RequestBody CartProductDto cartProductDto) {
		cartService.addProduct(cartProductDto);
	}

	@GetMapping("/cart/find/{cartId}")
	public CartDto findCard(@PathVariable long cartId) {
		CartDto cartDto = cartService.findCardWithCardProduct(cartId);
		return cartDto;
	}

	@GetMapping("/cart/update/{cartId}/{checkout}")
	public void updateCard(@PathVariable long cartId, @PathVariable boolean checkout) {
		cartService.updateCardCartStatus(cartId, checkout);
	}

	@DeleteMapping("/cart/{cartId}/remove/{productId}")
	public void removeProductFromCart(@PathVariable long cartId, @PathVariable long productId) {
		cartService.removeProductFromCart(cartId, productId);
	}
}
