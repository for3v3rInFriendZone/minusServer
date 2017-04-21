package com.minusServer.www.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minusServer.www.app.model.Item;
import com.minusServer.www.app.repository.ItemRepository;
import com.minusServer.www.app.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepo;

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return itemRepo.save(item);
	}

	@Override
	public Item findOne(Long id) {
		// TODO Auto-generated method stub
		return itemRepo.findOne(id);
	}

	@Override
	public Iterable<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemRepo.delete(id);
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		itemRepo.delete(item);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		itemRepo.deleteAll();
	}

}
