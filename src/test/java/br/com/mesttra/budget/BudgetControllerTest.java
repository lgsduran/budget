package br.com.mesttra.budget;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.mesttra.budget.controller.BudgetController;
import br.com.mesttra.budget.enums.Origem;
import br.com.mesttra.budget.enums.PossibleDestinations;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.repository.BudgetRepository;
import br.com.mesttra.budget.request.AddBudgetRequest;

@RunWith(MockitoJUnitRunner.class)
public class BudgetControllerTest {

	@Mock
	private BudgetRepository budgetRepository;

	@InjectMocks
	private BudgetController budgetController;
	
	@Test
	private void shouldNotSaveBudgetWithValuesLessThanTheTotalAmount() {
		try {
			AddBudgetRequest addBudgetRequest = new AddBudgetRequest();
			addBudgetRequest.setOrigem(Origem.COUNTY);
			addBudgetRequest.setPossibleDestinations(PossibleDestinations.SPORTS);
			addBudgetRequest.setSpentAmount(10);
			addBudgetRequest.setTotalAmount(0);
			budgetController.addVideo(addBudgetRequest);
			Assert.assertFalse(true);
		} catch (BusinessException e) {
			Assert.assertFalse(false);
		}
		

	}


}
