package com.minusServer.www.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.BillRepository;
import com.minusServer.www.app.service.BillService;
import com.minusServer.www.app.service.ItemService;
import com.minusServer.www.app.service.UserService;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
	@Override
	public Bill save(BillDto billDto) {
		
		Bill bill = new Bill();
		bill.setName(billDto.getName());
		bill.setIssuer(billDto.getIssuer());
		bill.setLocation(billDto.getLocation());
		bill.setPrice(billDto.getPrice());
		bill.setUser(userService.findOne(billDto.getUser()));
		
		for(int i = 0; i < billDto.getItems().size(); i++){
			bill.getItems().add(itemService.save(billDto.getItems().get(i)));
		}
		
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
	public List<Bill> findUserBills(Long user) {
		return billRepo.findByUser(userService.findOne(user));
	}
	

}
