package com.eshop.repositories;

import com.eshop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);

}

