package br.com.mesttra.budget.service;

import static java.lang.String.format;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mesttra.budget.entity.Budget;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.repository.BudgetRepository;
import br.com.mesttra.budget.request.AddBudgetRequest;
import br.com.mesttra.budget.request.ChangeBudgetExpenses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@Service
public class BudgetServiceImpl implements IBudgetService {

	BudgetRepository budgetRepository;

	@Override
	public Budget addBudget(AddBudgetRequest addBudgetRequest) {
		log.info("Budget added successfully.");
		return this.budgetRepository.save(addBudgetRequest.toEntity());
	}

	@Override
	public List<Budget> listBudgets() {
		return this.budgetRepository.findAll();
	}

	@Override
	public Budget changeBudgetExpenses(Long budgetId, ChangeBudgetExpenses changeBudgetExpenses)
			throws BusinessException {
		Budget budget = this.budgetRepository.findById(budgetId)
				.orElseThrow(() -> new BusinessException(format("Id %s not found.", budgetId)));

		if (changeBudgetExpenses.getSpentAmount() < budget.getTotalAmount() - budget.getSpentAmount()) {
			budget.setSpentAmount(changeBudgetExpenses.getSpentAmount());
			double newTotalAmount = budget.getTotalAmount() - changeBudgetExpenses.getSpentAmount();
			budget.setTotalAmount(newTotalAmount);
			log.info("Spent amount: {} ", changeBudgetExpenses.getSpentAmount());
			log.info("Total amount: {} ", newTotalAmount);
		} else {
			log.error("Value {} cannot be different from  (total - spent): ", changeBudgetExpenses.getSpentAmount());
			throw new BusinessException(
					format("Value %s cannot be different from (total - spent)", changeBudgetExpenses.getSpentAmount()));
		}

		return this.budgetRepository.save(budget);

	}

}
