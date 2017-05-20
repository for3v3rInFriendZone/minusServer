package com.minusServer.www.app.mapper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.mapper.ReferenceMapper;
import com.minusServer.www.app.mapper.service.BillMapperService;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.Item;
import com.minusServer.www.app.model.User;

@Service
@Transactional
public class BillMapperServiceImpl implements BillMapperService {

	@Autowired
	private ReferenceMapper referenceMapper;

	@Override
	public BillDto billToBillDTO(Bill bill) {
		if (bill == null) {
			return null;
		}

		BillDto billDto = new BillDto();

		billDto.setUserId(billUserId(bill));
		billDto.setId(bill.getId());
		billDto.setName(bill.getName());
		billDto.setLocation(bill.getLocation());
		billDto.setIssuer(bill.getIssuer());
		billDto.setDate(bill.getDate());
		billDto.setPrice(bill.getPrice());
		List<Integer> list = itemListToIntegerList(bill.getItems());
		if (list != null) {
			billDto.setItems(list);
		}

		return billDto;
	}

	@Override
	public List<BillDto> billsToBillDTOs(List<Bill> bills) {
		if (bills == null) {
			return null;
		}

		List<BillDto> list = new ArrayList<BillDto>();
		for (Bill bill : bills) {
			list.add(billToBillDTO(bill));
		}

		return list;
	}

	@Override
	public Bill billDTOToBill(BillDto billDTO) {
		if (billDTO == null) {
			return null;
		}

		Bill bill = new Bill();

		bill.setUser(referenceMapper.resolve(billDTO.getUserId(), User.class));
		bill.setId(billDTO.getId());
		bill.setName(billDTO.getName());
		bill.setLocation(billDTO.getLocation());
		bill.setIssuer(billDTO.getIssuer());
		bill.setDate(billDTO.getDate());
		bill.setPrice(billDTO.getPrice());
		List<Item> list = integerListToItemList(billDTO.getItems());
		if (list != null) {
			bill.setItems(list);
		}

		return bill;
	}

	@Override
	public void updateBillFromBillDto(Bill bill, BillDto billDTO) {
		if (billDTO == null) {
			return;
		}

		bill.setUser(referenceMapper.resolve(billDTO.getUserId(), User.class));
		bill.setId(billDTO.getId());
		bill.setName(billDTO.getName());
		bill.setLocation(billDTO.getLocation());
		bill.setIssuer(billDTO.getIssuer());
		bill.setDate(billDTO.getDate());
		bill.setPrice(billDTO.getPrice());
		if (bill.getItems() != null) {
			List<Item> list = integerListToItemList(billDTO.getItems());
			if (list != null) {
				bill.getItems().clear();
				bill.getItems().addAll(list);
			} else {
				bill.setItems(null);
			}
		} else {
			List<Item> list = integerListToItemList(billDTO.getItems());
			if (list != null) {
				bill.setItems(list);
			}
		}

	}

	@Override
	public List<Bill> billDTOsToBills(List<BillDto> billDTOs) {
		if (billDTOs == null) {
			return null;
		}

		List<Bill> list = new ArrayList<Bill>();
		for (BillDto billDto : billDTOs) {
			list.add(billDTOToBill(billDto));
		}

		return list;
	}

	private Integer billUserId(Bill bill) {

		if (bill == null) {
			return null;
		}
		User user = bill.getUser();
		if (user == null) {
			return null;
		}
		Integer id = user.getId();
		if (id == null) {
			return null;
		}
		return id;
	}

	protected List<Integer> itemListToIntegerList(List<Item> list) {
		if (list == null) {
			return null;
		}

		List<Integer> list_ = new ArrayList<Integer>();
		for (Item item : list) {
			list_.add(referenceMapper.toReference(item));
		}

		return list_;
	}

	protected List<Item> integerListToItemList(List<Integer> list) {
		if (list == null) {
			return null;
		}

		List<Item> list_ = new ArrayList<Item>();
		for (Integer integer : list) {
			list_.add(referenceMapper.resolve(integer, Item.class));
		}

		return list_;
	}

}
