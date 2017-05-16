package com.minusServer.www.app.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

		userService.save(userDto);
		return new ResponseEntity<UserDto>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAll() {

		List<UserDto> users =  (List<UserDto>) userService.findAll();

		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDto> login(@RequestBody String payload){
		
		JSONObject json = new JSONObject(payload);
		
		UserDto userDto = null;
		
		try {
			userDto = userService.login(json.getString("username"), json.getString("password"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if(userDto == null){
			return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}		
	}

}
