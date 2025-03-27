package com.matias.projects.profiles.interfaces;

import java.util.List;

import com.matias.projects.profiles.dto.UserCreateDto;
import com.matias.projects.profiles.dto.UserDto;

public interface UserService {
    public UserDto saveUser(UserCreateDto userCreateDto);
    public UserDto getUserById(Long id);
    public UserDto getUserByEmail(String email);
    public UserDto getUserByUsername(String username);
    public UserDto updateUser(UserCreateDto userCreateDto, Long id);
    public void deleteUser(Long id);
    public List<UserDto> getAllUsers();
    public List<UserDto> getUsersByRole(String roleName);
    public UserDto assignRolesToUser(Long userId, List<String> roles);
}
