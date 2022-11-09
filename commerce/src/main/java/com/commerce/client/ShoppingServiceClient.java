package com.commerce.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.commerce.business.dto.CartDto;
import com.commerce.business.dto.CartProductDto;

@Component
public class ShoppingServiceClient {

	public CartDto createCart(String customerName) {
		String url = "http://localhost:8082/shopping/cart/create/" + customerName;
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
		return cartDto;
	}

	public CartDto getCart(long cartId) {
		String url = "http://localhost:8082/shopping/cart/find/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);		
		return cartDto;
	}

	public void saveCartProduct(CartProductDto cartProductDto) {
		String url = "http://localhost:8082/shopping/cart/add";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<CartProductDto>(cartProductDto), Void.class);
	}

	public void deleteCartProduct(Long cartId, Long cartProductId) {
		String url = "http://localhost:8082/shopping/cart/" + cartId + "/remove/" + cartProductId; 
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

	public void updateCartCheckout(Long cartId, boolean checkout) {
		String url = "http://localhost:8082/shopping/cart/update/" + cartId + "/" + checkout;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);	
	}
}
