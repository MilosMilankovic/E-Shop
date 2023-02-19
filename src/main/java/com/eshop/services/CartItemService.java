package com.eshop.services;

import java.util.List;

import com.eshop.entities.Book;
import com.eshop.entities.CartItem;
import com.eshop.entities.ShoppingCart;
import com.eshop.entities.User;

public interface CartItemService {

	CartItem addBookToCartItem(Book book, User user, int qty);

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);

	CartItem updateCartItem(CartItem cartItem);

	void removeCartItem(CartItem cartItem);

	CartItem findById(Long id);

	CartItem save(CartItem cartItem);

}