package com.minusServer.www.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.BillRepository;
import com.minusServer.www.app.service.BillService;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepo;

	@Override
	public Bill save(Bill bill) {
		return billRepo.save(bill);
	}

	@Override
	public Bill findOne(Long id) {
		return billRepo.findOne(id);
	}

	@Override
	public Iterable<Bill> findAll() {
		return billRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		billRepo.delete(id);
	}

	@Override
	public void delete(Bill bill) {
		billRepo.delete(bill);
	}

	@Override
	public void deleteAll() {
		billRepo.deleteAll();
	}

	@Override
	public List<Bill> findUserBills(User user) {
		return billRepo.findByUser(user);
	}
	

}
