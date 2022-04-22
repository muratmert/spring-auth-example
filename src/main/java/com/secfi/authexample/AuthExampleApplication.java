package com.secfi.authexample;

import com.secfi.authexample.model.AppUser;
import com.secfi.authexample.model.AppUserRole;
import com.secfi.authexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class AuthExampleApplication implements CommandLineRunner {

	final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AuthExampleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... params) throws Exception {
		AppUser admin = new AppUser();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@email.com");
		admin.setUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_ADMIN)));

		userService.signup(admin);

		AppUser client = new AppUser();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@email.com");
		client.setUserRoles(new ArrayList<>(Arrays.asList(AppUserRole.ROLE_CLIENT)));

		userService.signup(client);
	}

}
