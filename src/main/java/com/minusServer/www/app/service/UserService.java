package com.minusServer.www.app.service;

import com.minusServer.www.app.model.User;

public interface UserService {

	public User save(User user);
	
	public Iterable<User> findAll();
	
	public User findOne(Long id);
	
	public void delete(Long id);
	
	public void delete(User u);
	
	public void deleteAll();
}
