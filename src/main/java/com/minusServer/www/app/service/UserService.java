package com.minusServer.www.app.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.model.User;

public interface UserService {

	public User save(UserDto user);
	
	public Iterable<User> findAll();
	
	public User findOne(Long id);
	
	public void delete(Long id);
	
	public void delete(User u);
	
	public void deleteAll();
	
	public String hashPassword(String password);
	
	public boolean autenticate(String rawPassword, String databasePassword);
	
	public User login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
