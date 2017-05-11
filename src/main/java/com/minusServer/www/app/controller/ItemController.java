package com.minusServer.www.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.model.Item;
import com.minusServer.www.app.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Item> save(@RequestBody Item item){
		return new ResponseEntity<Item>(itemService.save(item), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getAll(){
		return new ResponseEntity<List<Item>>((List<Item>) itemService.findAll(), HttpStatus.OK);
	}
}
