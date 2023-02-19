package com.eshop.services;

import com.eshop.entities.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	void clearShoppingCart(ShoppingCart shoppingCart);

}
