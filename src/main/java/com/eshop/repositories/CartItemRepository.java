package com.eshop.repositories;

import java.util.List;


import com.eshop.entities.CartItem;
import com.eshop.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;


public interface CartItemRepository extends CrudRepository<CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);
}