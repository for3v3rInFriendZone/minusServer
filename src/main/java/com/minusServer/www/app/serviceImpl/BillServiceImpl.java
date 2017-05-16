package com.minusServer.www.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.mapper.BillMapper;
import com.minusServer.www.app.mapper.UserMapper;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.BillRepository;
import com.minusServer.www.app.service.BillService;
import com.minusServer.www.app.service.ItemService;
import com.minusServer.www.app.service.UserService;

@Service
@Transactional
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BillMapper billMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public BillDto save(BillDto billDto) {
		
		Bill bill = billMapper.billDTOToBill(billDto);
		bill = billRepository.save(bill);
		return billMapper.billToBillDTO(bill);
	}

	@Override
	public BillDto findOne(Integer id) {
		BillDto billDto = billMapper.billToBillDTO( billRepository.findOne(id));
		return billDto;
	}

	@Override
	public List<BillDto> findAll() {
		return billMapper.billsToBillDTOs((List<Bill>) billRepository.findAll());
	}

	@Override
	public void delete(Integer id) {
		billRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		billRepository.deleteAll();
	}

	@Override
	public List<BillDto> findUserBills(Integer userId) {
		
		UserDto userDto = userService.findOne(userId);
		User user = userMapper.userDTOToUser(userDto);
		List<Bill> bills = billRepository.findByUser(user);
		return billMapper.billsToBillDTOs(bills);
	}
	

}
