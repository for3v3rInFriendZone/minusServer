package com.minusServer.www.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.minusServer.www.app.dto.UserDto;
import com.minusServer.www.app.model.User;


@Mapper(componentModel = "spring", uses = { ReferenceMapper.class })

public interface UserMapper {
	
	UserDto userToUserDTO(User user);

	List<UserDto> usersToUserDTOs(List<User> users);

	User userDTOToUser(UserDto userDTO);

	void updateUserFromUserDto(@MappingTarget User user, UserDto userDTO);

	List<User> userDTOsToUsers(List<UserDto> userDTOs);

}
