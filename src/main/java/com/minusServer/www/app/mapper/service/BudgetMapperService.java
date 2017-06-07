package com.minusServer.www.app.mapper.service;

import java.util.List;

import com.minusServer.www.app.dto.BudgetDto;
import com.minusServer.www.app.model.Budget;

public interface BudgetMapperService {

	BudgetDto budgetToBudgetDto(Budget budget);
	
	Budget budgetDtoToBudget(BudgetDto budgetDto);
	
	List<Budget> budgetsDtoToBudgets(List<BudgetDto> budgetsDto);
	
	List<BudgetDto> budgetsToBudgetsDto(List<Budget> budgets);
}
