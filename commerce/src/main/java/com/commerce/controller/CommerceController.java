package com.commerce.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.business.dto.CartDto;
import com.commerce.business.dto.CartProductDto;
import com.commerce.business.service.CommerceService;

@RestController
@RequestMapping("/commerce")
public class CommerceController {

	private CommerceService commerceService;

	public CommerceController(CommerceService commerceService) {
		this.commerceService = commerceService;
	}

	@GetMapping("/createCart/{customerName}")
	public CartDto createCart(@PathVariable String customerName){
		return commerceService.createCart(customerName);
	}
	
	@GetMapping("/getCart/{cardId}")
	public CartDto getCart(@PathVariable Long cardId){
		return commerceService.getCart(cardId);
	}
	
	@PostMapping("/addProduct")
	public CartDto addProductToCart(@RequestBody CartProductDto cartProductDto){
		return commerceService.addProduct(cartProductDto);
	}
	
	@DeleteMapping("/cart/{cartId}/remove/cartProduct/{productId}")
	public CartDto deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId){
		return commerceService.deleteCartProduct(cartId,productId);
	}
	
	@GetMapping("/cart/{cartId}/checkout/{checkout}")
	public CartDto deleteProductFromCart(@PathVariable Long cartId, @PathVariable boolean checkout){
		return commerceService.updateCartCheckOut(cartId,checkout);
	}

}
