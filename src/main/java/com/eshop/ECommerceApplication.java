package com.eshop;

import com.eshop.entities.Role;
import com.eshop.entities.User;
import com.eshop.entities.UserRole;
import com.eshop.repositories.RoleRepository;
import com.eshop.repositories.UserRepository;
import com.eshop.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories({"com.eshop.repositories"})
@EntityScan("com.eshop.entities")
public class ECommerceApplication /*implements CommandLineRunner*/ {

//	@Autowired
//	@Qualifier("passwordEncoder")
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Autowired
//	UserRoleRepository userRoleRepository;
//
//	@Autowired
//	RoleRepository roleRepository;
//
//	@Autowired
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		Role role = new Role();
//		role.setName("ADMIN");
//
//		roleRepository.save(role);
//
//		User user = new User();
//		user.setUsername("admin@gmail.com");
//		user.setPassword(passwordEncoder.encode("admin"));
//		user.setFirstName("Milan");
//
//		userRepository.save(user);
//
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleRepository.save(userRole);
//
//	}

}
