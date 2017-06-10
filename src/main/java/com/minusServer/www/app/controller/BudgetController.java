package com.minusServer.www.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.dto.BudgetDto;
import com.minusServer.www.app.service.BudgetServise;

@RestController
@RequestMapping(value = "/budget")
public class BudgetController {

	@Autowired
	BudgetServise budgetService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BudgetDto> save(@RequestBody BudgetDto budgetDto){
		return new ResponseEntity<BudgetDto>(budgetService.save(budgetDto), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BudgetDto>> findAll(){
		return new ResponseEntity<List<BudgetDto>>(budgetService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BudgetDto> getOne(@PathVariable("id") Long id){
		BudgetDto budgetDto = budgetService.findOne(id);
		
		if(budgetDto != null){
			return new ResponseEntity<BudgetDto>(budgetDto, HttpStatus.OK);
		}else{
			return new ResponseEntity<BudgetDto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<BudgetDto>> findUserBudgets(@PathVariable("id") Long id){
		return new ResponseEntity<List<BudgetDto>>(budgetService.findUserBudgets(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<BudgetDto> update(@RequestBody BudgetDto budgetDto){
		return new ResponseEntity<BudgetDto>(budgetService.updateStartValue(budgetDto), HttpStatus.OK);
	}
}
