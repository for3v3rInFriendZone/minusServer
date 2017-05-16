package com.minusServer.www.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;

public interface BillRepository extends CrudRepository<Bill, Integer>{

	public List<Bill> findByUser(User user);
}
