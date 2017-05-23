package com.minusServer.www.app.service;

import java.util.List;

import com.minusServer.www.app.dto.ItemDto;


public interface ItemService {

	public ItemDto save(ItemDto itemDTO);

	public ItemDto findOne(Long id);

	public List<ItemDto> findAll();

	public void delete(Long id);

	public void deleteAll();
}
