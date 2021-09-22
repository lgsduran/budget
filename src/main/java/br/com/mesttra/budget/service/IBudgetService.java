package br.com.mesttra.budget.service;

import java.util.List;

import br.com.mesttra.budget.entity.Budget;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.request.AddBudgetRequest;
import br.com.mesttra.budget.request.ChangeBudgetExpenses;

public interface IBudgetService {

	Budget addBudget(AddBudgetRequest addBudgetRequest);

	List<Budget> listBudgets();

	Budget changeBudgetExpenses(Long budgetId, ChangeBudgetExpenses changeBudgetExpenses) throws BusinessException;

}
