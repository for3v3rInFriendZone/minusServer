package com.minusServer.www.app.mapper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.mapper.service.ItemMapperService;
import com.minusServer.www.app.model.Item;

@Service
@Transactional
public class ItemMapperServiceImpl implements ItemMapperService {

	@Override
	public ItemDto itemToIteDTO(Item item) {
		if (item == null) {
			return null;
		}

		ItemDto itemDto = new ItemDto();

		itemDto.setId(item.getId());
		itemDto.setName(item.getName());
		itemDto.setQuantity(item.getQuantity());
		itemDto.setPrice(item.getPrice());

		return itemDto;
	}

	@Override
	public List<ItemDto> itemsToItemDTOs(List<Item> items) {
		if (items == null) {
			return null;
		}

		List<ItemDto> list = new ArrayList<ItemDto>();
		for (Item item : items) {
			list.add(itemToIteDTO(item));
		}

		return list;
	}

	@Override
	public Item itemDTOToItem(ItemDto itemDTO) {
		if (itemDTO == null) {
			return null;
		}

		Item item = new Item();

		item.setId(itemDTO.getId());
		item.setName(itemDTO.getName());
		item.setQuantity(itemDTO.getQuantity());
		item.setPrice(itemDTO.getPrice());

		return item;
	}

	@Override
	public void updateItemFromItemDto(Item item, ItemDto itemDTO) {
		if (itemDTO == null) {
			return;
		}

		item.setId(itemDTO.getId());
		item.setName(itemDTO.getName());
		item.setQuantity(itemDTO.getQuantity());
		item.setPrice(itemDTO.getPrice());
	}

	@Override
	public List<Item> itemDTOsToItems(List<ItemDto> itemDTOs) {
		if (itemDTOs == null) {
			return null;
		}

		List<Item> list = new ArrayList<Item>();
		for (ItemDto itemDto : itemDTOs) {
			list.add(itemDTOToItem(itemDto));
		}

		return list;
	}

}
