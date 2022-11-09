package com.commerce.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.commerce.business.dto.CartDto;
import com.commerce.business.dto.CartProductDto;
import com.commerce.business.dto.ProductDto;
import com.commerce.client.InventoryServiceClient;
import com.commerce.client.ShoppingServiceClient;

@Service
public class CommerceServiceImpl implements CommerceService {

	private ShoppingServiceClient shoppingServiceClient;
	private InventoryServiceClient inventoryServiceClient;

	CommerceServiceImpl(ShoppingServiceClient shoppingServiceClient, InventoryServiceClient inventoryServiceClient) {
		this.shoppingServiceClient = shoppingServiceClient;
		this.inventoryServiceClient = inventoryServiceClient;
	}

	@Override
	public CartDto createCart(String customerName) {
		return shoppingServiceClient.createCart(customerName);
	}

	@Override
	public CartDto getCart(Long cardId) {
		CartDto cartDto = shoppingServiceClient.getCart(cardId);
		cartDto = updateCartDtoProductName(cartDto);
		return cartDto;
	}

	@Override
	public CartDto addProduct(CartProductDto cartProductDto) {
		ProductDto productDto = inventoryServiceClient.getProduct(cartProductDto.getProductId());
		cartProductDto.setProductName(productDto.getProductName());
		cartProductDto.setProductId(productDto.getProductId());
		cartProductDto.setSalesPrice(productDto.getSalesPrice());
		shoppingServiceClient.saveCartProduct(cartProductDto);
		CartDto cartDto = shoppingServiceClient.getCart(cartProductDto.getCartId());
		cartDto = updateCartDtoProductName(cartDto);
		return cartDto;
	}

	@Override
	public CartDto deleteCartProduct(Long cartId, Long cartProductId) {
		shoppingServiceClient.deleteCartProduct(cartId, cartProductId);
		CartDto cartDto = shoppingServiceClient.getCart(cartId);
		return cartDto;
	}

	@Override
	public CartDto updateCartCheckOut(Long cartId, boolean checkout) {
		shoppingServiceClient.updateCartCheckout(cartId, checkout);
		CartDto cartDto = shoppingServiceClient.getCart(cartId);
		return cartDto;
	}
	
	private CartDto updateCartDtoProductName(CartDto cartDto) {
		List<CartProductDto> cartProductsDto = cartDto.getCartProductsDto();
		List<CartProductDto> newCartProductsDto = new ArrayList<CartProductDto>();
		for (int i=0; i<cartProductsDto.size(); i++) {
			CartProductDto newCartProductDto = cartProductsDto.get(i);
			ProductDto productDto = inventoryServiceClient.getProduct(newCartProductDto.getProductId());
			newCartProductDto.setProductName(productDto.getProductName());
			newCartProductsDto.add(newCartProductDto);
		}
		cartDto.setCartProductsDto(newCartProductsDto);
		return cartDto;
	}

}
