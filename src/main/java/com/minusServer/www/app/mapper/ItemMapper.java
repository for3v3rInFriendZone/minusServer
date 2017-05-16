package com.minusServer.www.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.model.Item;

@Mapper(componentModel = "spring", uses = { ReferenceMapper.class })

public interface ItemMapper {
	
	ItemDto itemToIteDTO(Item item);

	List<ItemDto> itemsToItemDTOs(List<Item> items);

	Item itemDTOToItem(ItemDto itemDTO);

	void updateItemFromItemDto(@MappingTarget Item item, ItemDto itemDTO);

	List<Item> itemDTOsToItems(List<ItemDto> itemDTOs);
}
