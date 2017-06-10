package com.minusServer.www.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.BudgetDto;
import com.minusServer.www.app.mapper.service.BudgetMapperService;
import com.minusServer.www.app.mapper.service.UserMapperService;
import com.minusServer.www.app.model.Budget;
import com.minusServer.www.app.repository.BudgetRepository;
import com.minusServer.www.app.service.BudgetServise;
import com.minusServer.www.app.service.UserService;

@Service
@Transactional
public class BudgetServiseImpl implements BudgetServise{

	@Autowired
	BudgetRepository budgetRepository;
	
	@Autowired
	BudgetMapperService budgetMapper;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapperService userMapper;
	
	@Override
	public BudgetDto save(BudgetDto budgetDto) {
		Budget budget = budgetMapper.budgetDtoToBudget(budgetDto);
		budgetRepository.save(budget);
		return budgetMapper.budgetToBudgetDto(budget);
	}

	@Override
	public BudgetDto findOne(Long id) {
		return budgetMapper.budgetToBudgetDto(budgetRepository.findOne(id));
	}

	@Override
	public List<BudgetDto> findAll(){ 
		return budgetMapper.budgetsToBudgetsDto((List<Budget>) budgetRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		budgetRepository.delete(id);
	}

	@Override
	public void delete(BudgetDto budgetDto) {
		budgetRepository.delete(budgetMapper.budgetDtoToBudget(budgetDto));
	}

	@Override
	public List<BudgetDto> findUserBudgets(Long userId) {
		return budgetMapper.budgetsToBudgetsDto((List<Budget>) budgetRepository.findByUser(userMapper.userDTOToUser(userService.findOne(userId))));
	}

	@Override
	public BudgetDto updateStartValue(BudgetDto budgetDto) {
		Budget budget = budgetRepository.findOne(budgetDto.getId());
		budget.setStartValue(budgetDto.getStartValue());
		budget.setCurrentValue(budgetDto.getCurrentValue());
		
		return budgetMapper.budgetToBudgetDto(budgetRepository.save(budget));
	}

}
