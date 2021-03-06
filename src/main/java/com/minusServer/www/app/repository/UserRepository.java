package com.minusServer.www.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.minusServer.www.app.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
}
