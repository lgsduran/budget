package br.com.mesttra.budget.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ChangeBudgetExpenses {
	
	@NotNull(message = "Element must not be null.")
	private Double spentAmount;

}
