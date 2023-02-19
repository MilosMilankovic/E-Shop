package com.eshop.repositories;

import com.eshop.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
