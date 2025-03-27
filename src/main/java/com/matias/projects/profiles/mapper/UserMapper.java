package com.matias.projects.profiles.mapper;

import com.matias.projects.profiles.dto.UserDto;
import com.matias.projects.profiles.models.User;

public class UserMapper {
    
    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUsername(user.getUsername());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
