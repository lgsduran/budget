package br.com.mesttra.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.budget.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
	
	

}
