package com.poc.shoecart.service;

import com.poc.shoecart.entity.Cart;

public interface CartService {

	public Cart getCartByUserId(long userId);

	public Cart addToCart(long userId, long productId);

}
