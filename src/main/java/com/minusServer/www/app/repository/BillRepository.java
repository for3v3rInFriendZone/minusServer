package com.minusServer.www.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{

	public List<Bill> findByUser(User user);
}
