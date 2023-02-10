package com.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories({"com.eshop.repositories"})
@EntityScan("com.eshop.entities")
@EnableSwagger2
@EnableWebMvc
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
