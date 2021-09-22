package br.com.mesttra.budget;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mesttra.budget.request.SignupRequest;
import br.com.mesttra.budget.service.AuthServiceImpl;

@SpringBootApplication
public class BudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(AuthServiceImpl authService) {
		return args -> {
			authService.registerUser(new SignupRequest("teste", "teste", Arrays.asList("ADMIN")));
		};		
	}

}
