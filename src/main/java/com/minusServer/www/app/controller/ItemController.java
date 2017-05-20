package com.minusServer.www.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.dto.ItemDto;
import com.minusServer.www.app.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ItemDto> save(@RequestBody ItemDto itemDto) {
		return new ResponseEntity<ItemDto>(itemService.save(itemDto), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemDto>> getAll() {
		return new ResponseEntity<List<ItemDto>>((List<ItemDto>) itemService.findAll(), HttpStatus.OK);
	}
}
