package com.minusServer.www.app.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.conf.AppConfig;
import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.mapper.service.UserMapperService;
import com.minusServer.www.app.model.User;
import com.minusServer.www.app.repository.UserRepository;
import com.minusServer.www.app.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AppConfig encoder;
	
	@Autowired
	UserMapperService userMapper;
	
	@Override
	public UserDto save(UserDto userDto) {
		String rawPassword = userDto.getPassword();
		userDto.setPassword(hashPassword(rawPassword));
		
		User user = userMapper.userDTOToUser(userDto);
		user = userRepository.save(user);
		return userMapper.userToUserDTO(user);
	}

	@Override
	public List<UserDto> findAll() {
		return userMapper.usersToUserDTOs((List<User>) userRepository.findAll());
	}

	@Override
	public UserDto findOne(Long id) {
		return userMapper.userToUserDTO(userRepository.findOne(id));
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public UserDto login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		User user = userRepository.findByUsername(username);
		
		if(user != null){
			if(autenticate(password, user.getPassword())){
				return userMapper.userToUserDTO(user);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String hashPassword(String password) {
		return encoder.passwordEncoder().encode(password);
	}

	@Override
	public boolean autenticate(String rawPassword, String databasePassword) {
		return encoder.passwordEncoder().matches(rawPassword, databasePassword);
	}

	@Override
	public UserDto update(UserDto userDto) {
		User user = userRepository.findOne(userDto.getId());
		userMapper.updateUserFromUserDto(user, userDto);
		return userMapper.userToUserDTO(userRepository.save(user));
	}

}
