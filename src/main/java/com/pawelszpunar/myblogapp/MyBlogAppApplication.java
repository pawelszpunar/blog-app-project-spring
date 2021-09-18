package com.pawelszpunar.myblogapp;

import com.pawelszpunar.myblogapp.entity.Role;
import com.pawelszpunar.myblogapp.entity.UserEntity;
import com.pawelszpunar.myblogapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MyBlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBlogAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserEntity()
					.setUsername("john")
					.setPassword("john123")
					.setRoles(new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_ADMIN");
		};
	}*/

		/*@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {

			userService.addRoleToUser("admin", "ROLE_ADMIN");
		};
	}*/

}
