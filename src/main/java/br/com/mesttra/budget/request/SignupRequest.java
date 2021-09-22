package br.com.mesttra.budget.request;

import java.util.Collection;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SignupRequest {

	@NotBlank
    private String username;
    
    @NotBlank
    private String password;    
    
    private Collection<String> role;

}
