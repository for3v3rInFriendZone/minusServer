package com.minusServer.www.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.minusServer.www.app.model.Budget;
import com.minusServer.www.app.model.User;

public interface BudgetRepository extends CrudRepository<Budget, Long>{

	public List<Budget> findByUser(User user);
}
