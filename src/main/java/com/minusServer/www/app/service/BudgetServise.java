package com.minusServer.www.app.service;

import java.util.List;

import com.minusServer.www.app.dto.BudgetDto;

public interface BudgetServise {

	public BudgetDto save(BudgetDto budgetDto);
	
	public BudgetDto findOne(Long id);
	
	public List<BudgetDto> findAll();
	
	public void delete(Long id);
	
	public void delete(BudgetDto budgetDto);
	
	public List<BudgetDto> findUserBudgets(Long userId);
	
	public BudgetDto updateStartValue(BudgetDto budgetDto);
	
}
