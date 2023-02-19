package com.eshop;

import com.eshop.entities.Role;
import com.eshop.entities.User;
import com.eshop.entities.UserRole;
import com.eshop.repositories.RoleRepository;
import com.eshop.repositories.UserRepository;
import com.eshop.repositories.UserRoleRepository;
import com.eshop.security.ERole;
import com.eshop.services.UserService;
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

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories({"com.eshop.repositories"})
@EntityScan("com.eshop.entities")
@EnableSwagger2
@EnableWebMvc
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(passwordEncoder.encode("p"));
		user1.setUsername("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setId(1);
		role1.setName(ERole.ROLE_USER);
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(passwordEncoder.encode("p"));
		user2.setUsername("Admin@gmail.com");
		Role role2 = new Role();
		role2.setId(2);
		role2.setName(ERole.ROLE_ADMIN);
		userRoles.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles);



	}

}
