package com.minusServer.www.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.model.User;
import com.minusServer.www.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam("username") String username, @RequestParam("password")String password){
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		
		List<User> users = new ArrayList<User>();
		
		users = (List<User>) userService.findAll();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
}
