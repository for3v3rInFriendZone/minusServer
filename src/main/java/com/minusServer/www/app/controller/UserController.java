package com.minusServer.www.app.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.minusServer.www.app.dto.LoginData;
import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.model.Bill;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.service.BillService;
import com.minusServer.www.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BillService billService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody UserDto user) {

		userService.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll() {

		List<User> users = new ArrayList<User>();
		users = (List<User>) userService.findAll();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody LoginData loginData){
		
		User user = null;
		
		try {
			user = userService.login(loginData.getUsername(), loginData.getPassword());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user == null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/userBills/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Bill>> getUserBills(@PathVariable Long userId){
		
		return new ResponseEntity<List<Bill>>(billService.findUserBills(userId), HttpStatus.OK);
		
	}
		

}
