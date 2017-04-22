package com.minusServer.www.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.UserRepository;
import com.minusServer.www.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		userRepository.delete(u);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

}
