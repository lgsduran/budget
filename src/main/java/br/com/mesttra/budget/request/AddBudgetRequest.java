package br.com.mesttra.budget.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import br.com.mesttra.budget.entity.Budget;
import br.com.mesttra.budget.enums.Origem;
import br.com.mesttra.budget.enums.PossibleDestinations;
import lombok.Data;

@Data
public class AddBudgetRequest {

	@NotNull(message = "Element must not be null.")
	private double totalAmount;

	@NotNull(message = "Element must not be null.")
	private double spentAmount;

	@Enumerated(EnumType.STRING)
	private PossibleDestinations possibleDestinations;
	
	@Enumerated(EnumType.STRING)
	private Origem origem;

	public Budget toEntity() {
		Budget budget = new Budget();
		BeanUtils.copyProperties(this, budget);
		return budget;
	}

}
