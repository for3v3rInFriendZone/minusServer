package com.minusServer.www.app.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.minusServer.www.app.model.User;

public interface UserService {

	public User save(User user);
	
	public Iterable<User> findAll();
	
	public User findOne(Long id);
	
	public void delete(Long id);
	
	public void delete(User u);
	
	public void deleteAll();
	
	public byte[] generateSalt() throws NoSuchAlgorithmException;
	
	public byte[] hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public boolean autenticate(String loginPassword, byte[] databasePassword, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException;
	
	public User login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
