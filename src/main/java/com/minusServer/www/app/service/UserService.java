package com.minusServer.www.app.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.minusServer.www.app.dto.UserDto;


public interface UserService {

	public UserDto save(UserDto userDTO);
	
	public Iterable<UserDto> findAll();
	
	public UserDto findOne(Integer id);
	
	public void delete(Integer id);
	
	public void deleteAll();
	
	public String hashPassword(String password);
	
	public boolean autenticate(String rawPassword, String databasePassword);
	
	public UserDto login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
