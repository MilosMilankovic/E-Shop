package com.eshop;

import com.eshop.entities.Role;
import com.eshop.entities.User;
import com.eshop.entities.UserRole;
import com.eshop.repositories.RoleRepository;
import com.eshop.repositories.UserRepository;
import com.eshop.repositories.UserRoleRepository;
import com.eshop.security.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories({"com.eshop.repositories"})
@EntityScan("com.eshop.entities")
@EnableSwagger2
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		if (userRepository.existsByUsername("admin@gmail.com") && userRepository.existsByUsername("user@gmail.com"))
			return;

		Role role = new Role();
		role.setName(ERole.ROLE_ADMIN);

		roleRepository.save(role);

		User user = new User();
		user.setUsername("admin@gmail.com");

		user.setPassword(passwordEncoder.encode("admin"));

		user.setFirstName("Milan");
		user.setLastName("Milankovic");

		userRepository.save(user);

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		userRoleRepository.save(userRole);




		Role role2 = new Role();
		role2.setName(ERole.ROLE_USER);

		roleRepository.save(role2);

		User user2 = new User();
		user2.setUsername("user@gmail.com");

		user2.setPassword(passwordEncoder.encode("user"));

		user2.setFirstName("Pera");
		user2.setLastName("Peric");

		userRepository.save(user2);

		UserRole userRole2 = new UserRole();
		userRole2.setRole(role2);
		userRole2.setUser(user2);

		userRoleRepository.save(userRole2);

	}

}
