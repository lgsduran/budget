package br.com.mesttra.budget.service;

import org.springframework.http.ResponseEntity;

import br.com.mesttra.budget.request.LoginRequest;
import br.com.mesttra.budget.request.SignupRequest;

public interface IAuthService {
	
	ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

	ResponseEntity<?> registerUser(SignupRequest signUpRequest);

}
