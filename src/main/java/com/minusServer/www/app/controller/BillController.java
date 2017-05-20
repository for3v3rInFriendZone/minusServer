package com.minusServer.www.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.service.BillService;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	BillService billService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<BillDto> saveBill(@RequestBody BillDto billDto){
		return new ResponseEntity<BillDto>(billService.save(billDto), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<BillDto>> getAll(){
		return new ResponseEntity<List<BillDto>>((List<BillDto>)billService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<BillDto>> getUserBills(@Param(value = "id") Integer id){
		return new ResponseEntity<List<BillDto>>(billService.findUserBills(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<BillDto> getOne(@PathVariable("id") Integer id){
		
		BillDto billDto = billService.findOne(id);
		
		if(billDto != null){
			return new ResponseEntity<BillDto>(billDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<BillDto>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BillDto> deleteBill(@PathVariable("id") Integer id) {

		billService.delete(id);
		
		return new ResponseEntity<BillDto>(HttpStatus.OK);
	}
}
