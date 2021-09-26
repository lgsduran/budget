package br.com.mesttra.budget.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.budget.entity.Budget;
import br.com.mesttra.budget.exception.BusinessException;
import br.com.mesttra.budget.request.AddBudgetRequest;
import br.com.mesttra.budget.request.ChangeBudgetExpenses;
import br.com.mesttra.budget.service.BudgetServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
//@RequiredArgsConstructor
@RestController
@RequestMapping("/budgets")
public class BudgetController {

	private BudgetServiceImpl budgetService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Budget addBudget(@Valid @RequestBody AddBudgetRequest addBudgetRequest) throws BusinessException {
		return this.budgetService.addBudget(addBudgetRequest);
	}

	@GetMapping("/budgets")
	public List<Budget> listBudgets() {
		return this.budgetService.listBudgets();
	}

	@PatchMapping("/{budgetId}/expense")
	public Budget changeBudgetExpenses(@PathVariable long budgetId,
			@RequestBody ChangeBudgetExpenses changeBudgetExpenses) throws BusinessException {
		return this.budgetService.changeBudgetExpenses(budgetId, changeBudgetExpenses);
	}

}
