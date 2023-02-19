package com.eshop.repositories;

import com.eshop.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
