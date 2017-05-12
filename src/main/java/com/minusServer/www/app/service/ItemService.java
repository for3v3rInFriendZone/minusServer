package com.minusServer.www.app.service;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.model.Item;

public interface ItemService {

	public Item save(ItemDto item);

	public Item findOne(Long id);

	public Iterable<Item> findAll();

	public void delete(Long id);

	public void delete(Item item);

	public void deleteAll();
}
