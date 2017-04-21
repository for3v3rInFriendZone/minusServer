package com.minusServer.www.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.repository.BillRepository;
import com.minusServer.www.app.service.BillService;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepo;

	@Override
	public Bill save(Bill bill) {
		// TODO Auto-generated method stub
		return billRepo.save(bill);
	}

	@Override
	public Bill findOne(Long id) {
		// TODO Auto-generated method stub
		return billRepo.findOne(id);
	}

	@Override
	public Iterable<Bill> findAll() {
		// TODO Auto-generated method stub
		return billRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		billRepo.delete(id);
	}

	@Override
	public void delete(Bill bill) {
		// TODO Auto-generated method stub
		billRepo.delete(bill);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		billRepo.deleteAll();
	}
	

}
