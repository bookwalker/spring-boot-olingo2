package com.example.contact;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ContactServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(ContactRepository contactRepository) {
		return args -> {
			Stream.of("John Doe", "Jane Doe", "John Roe", "Jane Roe")
					.forEach(name -> contactRepository.save(new Contact(name)));
		};
	}
}
