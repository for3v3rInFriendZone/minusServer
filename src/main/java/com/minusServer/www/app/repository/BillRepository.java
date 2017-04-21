package com.minusServer.www.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.minusServer.www.app.model.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{

}
