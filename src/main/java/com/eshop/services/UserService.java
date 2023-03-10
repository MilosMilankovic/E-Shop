package com.eshop.services;

import com.eshop.entities.User;
import com.eshop.entities.UserRole;

import java.util.Set;

public interface UserService {

 //   PasswordResetToken getPasswordResetToken(final String token);

 //   void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    Boolean existsByUsername(String username);

}
