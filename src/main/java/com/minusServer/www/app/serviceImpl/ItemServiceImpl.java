package com.minusServer.www.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.mapper.ItemMapper;
import com.minusServer.www.app.model.Item;
import com.minusServer.www.app.repository.ItemRepository;
import com.minusServer.www.app.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemMapper itemMapper;

	@Override
	public ItemDto save(ItemDto itemDto) {

		Item item = itemMapper.itemDTOToItem(itemDto);
		item = itemRepository.save(item);
		return itemMapper.itemToIteDTO(item);
	}

	@Override
	public ItemDto findOne(Integer id) {
		return itemMapper.itemToIteDTO(itemRepository.findOne(id));
	}

	@Override
	public List<ItemDto> findAll() {
		return itemMapper.itemsToItemDTOs((List<Item>) itemRepository.findAll());
	}

	@Override
	public void delete(Integer id) {
		itemRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		itemRepository.deleteAll();
	}

}
	