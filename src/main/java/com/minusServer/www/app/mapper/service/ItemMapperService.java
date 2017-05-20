package com.minusServer.www.app.mapper.service;

import java.util.List;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.model.Item;

public interface ItemMapperService {
	
	ItemDto itemToIteDTO(Item item);

	List<ItemDto> itemsToItemDTOs(List<Item> items);

	Item itemDTOToItem(ItemDto itemDTO);

	void updateItemFromItemDto(Item item, ItemDto itemDTO);

	List<Item> itemDTOsToItems(List<ItemDto> itemDTOs);

}
