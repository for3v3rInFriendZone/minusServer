package com.minusServer.www.app.mapper.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.mapper.ReferenceMapper;
import com.minusServer.www.app.mapper.service.BillMapperService;
import com.minusServer.www.app.mapper.service.ItemMapperService;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.Item;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.service.ItemService;

@Service
@Transactional
public class BillMapperServiceImpl implements BillMapperService {

	@Autowired
	private ReferenceMapper referenceMapper;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemMapperService itemMapper;

	@Override
	public BillDto billToBillDTO(Bill bill) {
		if (bill == null) {
			return null;
		}

		BillDto billDto = new BillDto();

		billDto.setUser(billUser(bill));
		billDto.setId(bill.getId());
		billDto.setName(bill.getName());
		billDto.setLocation(bill.getLocation());
		billDto.setIssuer(bill.getIssuer());

		if (bill.getDate() != null) {
			billDto.setDate(bill.getDate().getTime());
		}
		
		billDto.setPrice(bill.getPrice());
		
		List<ItemDto> list = itemListToIntegerList(bill.getItems());
		
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
		
		if(billDTO.getId() != null){
			bill.setUser(referenceMapper.resolve(billDTO.getUser().getId(), User.class));
			bill.setId(billDTO.getId());
			bill.setName(billDTO.getName());
			bill.setLocation(billDTO.getLocation());
			bill.setIssuer(billDTO.getIssuer());
			if (billDTO.getDate() != null) {
				Date date = new Date(billDTO.getDate());
				bill.setDate(date);
			}
			bill.setPrice(billDTO.getPrice());
			List<Item> list = integerListToItemList(billDTO.getItems());
			if (list != null) {
				bill.setItems(list);
			}
		} else {
			bill.setUser(referenceMapper.resolve(billDTO.getUser().getId(), User.class));
			bill.setName(billDTO.getName());
			bill.setLocation(billDTO.getLocation());
			bill.setIssuer(billDTO.getIssuer());
			if (billDTO.getDate() != null) {
				Date date = new Date(billDTO.getDate());
				bill.setDate(date);
			}
			bill.setPrice(billDTO.getPrice());
			/*List<Item> list = integerListToItemList(billDTO.getItems());
			if (list != null) {
				bill.setItems(list);
			}*/
			if(!billDTO.getItems().isEmpty()){
				for(ItemDto itemDto : billDTO.getItems()){
					bill.getItems().add(itemMapper.itemDTOToItem(itemService.save(itemDto)));
				}
			}
		}

		return bill;
	}

	@Override
	public void updateBillFromBillDto(Bill bill, BillDto billDTO) {
		if (billDTO == null) {
			return;
		}

		bill.setUser(referenceMapper.resolve(billDTO.getUser().getId(), User.class));
		bill.setId(billDTO.getId());
		bill.setName(billDTO.getName());
		bill.setLocation(billDTO.getLocation());
		bill.setIssuer(billDTO.getIssuer());
		if (billDTO.getDate() != null) {
			Date date = new Date(billDTO.getDate());
			bill.setDate(date);
		}
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

	private UserDto billUser(Bill bill) {

		if (bill == null) {
			return null;
		}
		
		User user = bill.getUser();
		
		if (user == null) {
			return null;
		}
		
		UserDto userDto = new UserDto();
		
		userDto.setEmail(user.getEmail());
		userDto.setFirstname(user.getFirstname());
		userDto.setId(user.getId());
		userDto.setImage(user.getImage());
		userDto.setLastname(user.getLastname());
		userDto.setPassword(user.getPassword());
		userDto.setUsername(user.getUsername());
		
		return userDto;
	}

	protected List<ItemDto> itemListToIntegerList(List<Item> list) {
		if (list == null) {
			return null;
		}

		List<ItemDto> list_ = new ArrayList<ItemDto>();
		
		for (Item item : list) {
			ItemDto _item = new ItemDto();
			
			_item.setId(item.getId());
			_item.setName(item.getName());
			_item.setPrice(item.getPrice());
			_item.setQuantity(item.getQuantity());
			list_.add(_item);
		}

		return list_;
	}

	protected List<Item> integerListToItemList(List<ItemDto> list) {
		if (list == null) {
			return null;
		}

		List<Item> list_ = new ArrayList<Item>();
		for (ItemDto item : list) {
			Item _item = new Item();
			_item.setId(item.getId());
			_item.setName(item.getName());
			_item.setPrice(item.getPrice());
			_item.setQuantity(item.getQuantity());
			list_.add(_item);
		}

		return list_;
	}

}
