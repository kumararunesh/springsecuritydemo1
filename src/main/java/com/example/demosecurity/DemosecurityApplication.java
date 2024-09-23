package com.example.demosecurity;

import com.example.demosecurity.entities.User;
import com.example.demosecurity.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemosecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemosecurityApplication.class, args);
	}
    @Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {

		User user = userRepository.findByUsername("raj").orElse(null);

        if(user==null) {
			user = new User();
			user.setUsername("raj");
			user.setPassword(passwordEncoder.encode("raj"));
			user.setRole("USER");
			userRepository.save(user);
			System.out.println("User is created");
		}

	}
}
