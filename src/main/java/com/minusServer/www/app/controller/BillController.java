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
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.service.BillService;

@RestController
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	BillService billService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Bill> saveBill(@RequestBody BillDto bill){
		
		return new ResponseEntity<Bill>(billService.save(bill), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Bill>> getAll(){
		return new ResponseEntity<List<Bill>>((List<Bill>)billService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Bill> getOne(@PathVariable("id") Long id){
		
		Bill bill = billService.findOne(id);
		
		if(bill != null){
			return new ResponseEntity<Bill>(bill, HttpStatus.OK);
		} else {
			return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Bill> deleteBill(@PathVariable("id") Long id) {

		billService.delete(id);
		
		return new ResponseEntity<Bill>(HttpStatus.OK);
	}
}
