package com.poc.shoecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoecart.entity.Cart;
import com.poc.shoecart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/getCartByUserId/{userId}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId") long userId) {

		Cart cartItem = null;

		try {
			cartItem = cartService.getCartByUserId(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);
	}

	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addItemToCart(@RequestBody Cart cart) {
		Cart cartItem = null;

		try {
			cartItem = cartService.addToCart(cart.getUsers().getUserId(),cart.getProducts().getProductId());
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);

	}

}
