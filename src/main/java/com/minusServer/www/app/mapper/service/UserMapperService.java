package com.minusServer.www.app.mapper.service;

import java.util.List;

import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.model.User;

public interface UserMapperService {
	
	UserDto userToUserDTO(User user);

	List<UserDto> usersToUserDTOs(List<User> users);

	User userDTOToUser(UserDto userDTO);

	void updateUserFromUserDto(User user, UserDto userDTO);

	List<User> userDTOsToUsers(List<UserDto> userDTOs);


}
