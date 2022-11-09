package shopping.business.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import shopping.business.dto.CartDto;
import shopping.business.dto.CartProductDto;
import shopping.data.entity.Cart;
import shopping.data.entity.CartProduct;
import shopping.data.repository.CartProductRepository;
import shopping.data.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;
	private final CartProductRepository cartProductRepository;

	public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public CartDto createCard(String customerName) {
		Cart cart = new Cart();
		cart.setCustomerName(customerName);
		cart.setCartStatus(false);
		cart.setTotalAmount(BigDecimal.ZERO);
		Cart savedCart = cartRepository.save(cart);
		return cartEntityToCart(savedCart);
	}

	@Override
	public CartDto addProduct(CartProductDto cartProductDto) {

		// productPrice ı diğer servisten alsın
		CartProduct cartProduct = new CartProduct();
		cartProduct.setCartId(cartProductDto.getCartId());
		cartProduct.setCartProductId(cartProductDto.getCartProductId());
		cartProduct.setProductId(cartProductDto.getProductId());
		cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
		cartProduct.setLineAmount(
				cartProductDto.getSalesPrice().multiply(BigDecimal.valueOf(cartProductDto.getSalesQuantity())));
		Cart cart = findCard(cartProductDto.getCartId());
		cart.setTotalAmount(cart.getTotalAmount().add(cartProduct.getLineAmount()));
		cartProductRepository.save(cartProduct);
		cartRepository.save(cart);
		return cartEntityToCart(cart);
	}

	@Override
	public Cart findCard(Long cartId) {
		Optional<Cart> cartOpt = cartRepository.findById(cartId);
		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			return cart;
		}
		return null;
	}

	@Override
	public CartDto findCardWithCardProduct(Long cartId) {
		Optional<Cart> cartOpt = cartRepository.findById(cartId);
		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			Optional<List<CartProduct>> cartProductsOpt = cartProductRepository.findByCartId(cartId);
			if (cartProductsOpt.isPresent()) {
				
				List<CartProduct> cartProducts = cartProductsOpt.get();
				return cartEntityToCart(cart, cartProducts);
			}
		}
		return null;
	}

	@Override
	public void updateCardCartStatus(long cartId, boolean checkout) {
		Optional<Cart> cartOpt = cartRepository.findById(cartId);
		if (cartOpt.isPresent()) {
			Cart cart = cartOpt.get();
			cart.setCartStatus(checkout);
			cartRepository.save(cart);
		}
	}

	@Override
	public void removeProductFromCart(long cartId, long productId) {
		Optional<CartProduct> cartProductOpt = cartProductRepository.findById(productId);
		if (cartProductOpt.isPresent()) {
			CartProduct cartProduct = cartProductOpt.get();
			Optional<Cart> cartOpt = cartRepository.findById(cartId);
			if (cartOpt.isPresent()) {
				Cart cart = cartOpt.get();
				cart.setTotalAmount(cart.getTotalAmount().subtract(cartProduct.getLineAmount()));
				cartRepository.save(cart);
				cartProductRepository.delete(cartProduct);
			}
		}
	}

	private CartDto cartEntityToCart(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setCartId(cart.getCartId());
		cartDto.setCartStatus(cart.isCartStatus());
		cartDto.setCustomerName(cart.getCustomerName());
		cartDto.setTotalAmount(cart.getTotalAmount());
		return cartDto;
	}

	private CartDto cartEntityToCart(Cart cart, List<CartProduct> cartProducts) {
		CartDto cartDto = new CartDto();
		cartDto.setCartId(cart.getCartId());
		cartDto.setCartStatus(cart.isCartStatus());
		cartDto.setCustomerName(cart.getCustomerName());
		cartDto.setTotalAmount(cart.getTotalAmount());
		List<CartProductDto> cartProductsDto = new ArrayList<CartProductDto>();
		cartProducts.forEach((cp) -> cartProductsDto.add(cartProductEntityToCartProductDto(cp)));
		cartDto.setCartProductsDto(cartProductsDto);
		return cartDto;
	}

	private CartProductDto cartProductEntityToCartProductDto(CartProduct cartProduct) {
		CartProductDto cartProductDto = new CartProductDto();
		cartProductDto.setCartId(cartProduct.getCartId());
		cartProductDto.setCartProductId(cartProduct.getCartProductId());
		cartProductDto.setLineAmount(cartProduct.getLineAmount());
		cartProductDto.setProductId(cartProduct.getProductId());
		cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
		cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
		return cartProductDto;
	}

}
