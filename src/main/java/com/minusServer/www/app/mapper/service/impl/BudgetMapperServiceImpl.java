package com.minusServer.www.app.mapper.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.BudgetDto;
import com.minusServer.www.app.mapper.ReferenceMapper;
import com.minusServer.www.app.mapper.service.BudgetMapperService;
import com.minusServer.www.app.mapper.service.UserMapperService;
import com.minusServer.www.app.model.Budget;

@Service
@Transactional
public class BudgetMapperServiceImpl implements BudgetMapperService{

	@Autowired
	private ReferenceMapper referenceMapper;
	
	@Autowired
	private UserMapperService userMapperServise;
	
	@Override
	public BudgetDto budgetToBudgetDto(Budget budget) {
		if(budget == null){
			return null;
		}
		
		BudgetDto budgetDto = new BudgetDto();
		
		budgetDto.setId(budget.getId());
		budgetDto.setDateFrom(budget.getDateFrom().getTime());
		budgetDto.setDateTo(budget.getDateTo().getTime());
		budgetDto.setStartValue(budget.getStartValue());
		budgetDto.setCurrentValue(budget.getCurrentValue());
		budgetDto.setUser(userMapperServise.userToUserDTO(budget.getUser()));
		return budgetDto;
	}

	@Override
	public Budget budgetDtoToBudget(BudgetDto budgetDto) {
		if(budgetDto == null)
			return null;
		
		Budget budget = new Budget();
		
		budget.setId(budgetDto.getId());
		budget.setDateFrom(new Date(budgetDto.getDateFrom()));
		budget.setDateTo(new Date(budgetDto.getDateTo()));
		budget.setStartValue(budgetDto.getStartValue());
		budget.setCurrentValue(budgetDto.getCurrentValue());
		budget.setUser(userMapperServise.userDTOToUser(budgetDto.getUser()));
		
		return budget;
	}

	@Override
	public List<Budget> budgetsDtoToBudgets(List<BudgetDto> budgetsDto) {
		if(budgetsDto ==null)
			return null;
		
		List<Budget> budgets = new ArrayList<Budget>();
		
		for(BudgetDto budgetDto : budgetsDto){
			budgets.add(budgetDtoToBudget(budgetDto));
		}
		
		return budgets;
	}

	@Override
	public List<BudgetDto> budgetsToBudgetsDto(List<Budget> budgets) {
		if(budgets == null)
			return null;
		
		List<BudgetDto> budgetsDto = new ArrayList<BudgetDto>();
		
		for(Budget budget : budgets){
			budgetsDto.add(budgetToBudgetDto(budget));
		}
		
		return budgetsDto;
	}

}
