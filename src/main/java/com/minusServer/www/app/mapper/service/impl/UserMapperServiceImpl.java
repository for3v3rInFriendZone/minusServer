package com.minusServer.www.app.mapper.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.mapper.service.UserMapperService;
import com.minusServer.www.app.model.User;

@Service
@Transactional
public class UserMapperServiceImpl implements UserMapperService {

	@Override
	public UserDto userToUserDTO(User user) {
		if (user == null) {
			return null;
		}

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setFirstname(user.getFirstname());
		userDto.setLastname(user.getLastname());
		userDto.setEmail(user.getEmail());
		userDto.setImage(user.getImage());
		userDto.setColour(user.getColour());
		userDto.setFont(user.getFont());

		return userDto;
	}

	@Override
	public List<UserDto> usersToUserDTOs(List<User> users) {
		if (users == null) {
			return null;
		}

		List<UserDto> list = new ArrayList<UserDto>();
		for (User user : users) {
			list.add(userToUserDTO(user));
		}

		return list;
	}

	@Override
	public User userDTOToUser(UserDto userDTO) {
		if (userDTO == null) {
			return null;
		}

		User user = new User();

		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setImage(userDTO.getImage());
		user.setColour(userDTO.getColour());
		user.setFont(userDTO.getFont());

		return user;
	}

	@Override
	public void updateUserFromUserDto(User user, UserDto userDTO) {
		if (userDTO == null) {
			return;
		}

		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setImage(userDTO.getImage());
		user.setColour(userDTO.getColour());
		user.setFont(userDTO.getFont());

	}

	@Override
	public List<User> userDTOsToUsers(List<UserDto> userDTOs) {
		if (userDTOs == null) {
			return null;
		}

		List<User> list = new ArrayList<User>();
		for (UserDto userDto : userDTOs) {
			list.add(userDTOToUser(userDto));
		}

		return list;
	}

}
