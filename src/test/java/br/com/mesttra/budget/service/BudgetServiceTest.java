package br.com.mesttra.budget.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.request.AddBudgetRequest;

class BudgetServiceTest {	
    
   private final BudgetServiceImpl mockedBudgetService = mock(BudgetServiceImpl.class);

	@Test
	void shouldNotSaveSpentAmountHigherThanTotalAmount() throws Exception {
		AddBudgetRequest addBudgetRequest = new AddBudgetRequest();
		addBudgetRequest.setSpentAmount(10);
		addBudgetRequest.setTotalAmount(0);
		
		when(this.mockedBudgetService.addBudget(addBudgetRequest))
			.thenThrow(new BusinessException(
					String.format("Spent Amout %s cannot be higher than Total Amount %s", 
							addBudgetRequest.getSpentAmount(),
							addBudgetRequest.getTotalAmount())));

	}

}
