package com.commerce.business.service;

import com.commerce.business.dto.CartDto;
import com.commerce.business.dto.CartProductDto;

public interface CommerceService {

	public CartDto createCart(String customerName);

	public CartDto addProduct(CartProductDto cartProductDto);

	public CartDto getCart(Long cardId);

	public CartDto deleteCartProduct(Long cardId, Long productId);

	public CartDto updateCartCheckOut(Long cartId, boolean checkout);
}
