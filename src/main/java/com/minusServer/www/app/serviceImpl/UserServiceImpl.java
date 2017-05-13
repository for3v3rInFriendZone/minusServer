package com.minusServer.www.app.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minusServer.www.app.conf.AppConfig;
import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.UserRepository;
import com.minusServer.www.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppConfig encoder;

	@Override
	public User save(UserDto userDto) {

		User user = new User();

		user.setEmail(userDto.getEmail());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setUsername(userDto.getUsername());
		user.setPassword(hashPassword(userDto.getPassword()));
		user.setImage(userDto.getImage());

		return userRepository.save(user);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void delete(User u) {
		userRepository.delete(u);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public User login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

		User user = userRepository.findByUsername(username);

		if (user != null) {
			if (autenticate(password, user.getPassword())) {
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String hashPassword(String password) {
		// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.passwordEncoder().encode(password);
	}

	@Override
	public boolean autenticate(String rawPassword, String databasePassword) {
		return encoder.passwordEncoder().matches(rawPassword, databasePassword);
	}

}
