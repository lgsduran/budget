package br.com.mesttra.budget.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.budget.request.LoginRequest;
import br.com.mesttra.budget.request.SignupRequest;
import br.com.mesttra.budget.service.AuthServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/budget/auth/")
public class AuthController {

	private AuthServiceImpl authService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return this.authService.authenticateUser(loginRequest);

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return this.authService.registerUser(signUpRequest);

	}

}