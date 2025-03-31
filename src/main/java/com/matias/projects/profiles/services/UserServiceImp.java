package com.matias.projects.profiles.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.matias.projects.profiles.dto.UserCreateDto;
import com.matias.projects.profiles.dto.UserDto;
import com.matias.projects.profiles.exception.UserNotFoundException;
import com.matias.projects.profiles.interfaces.UserService;
import com.matias.projects.profiles.mapper.UserMapper;
import com.matias.projects.profiles.models.Role;
import com.matias.projects.profiles.models.User;
import com.matias.projects.profiles.repositories.RoleRepository;
import com.matias.projects.profiles.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto saveUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword( passwordEncoder.encode(userCreateDto.getPassword()) );
        user.setPhoneNumber(userCreateDto.getPhoneNumber());
        user.setDisable(userCreateDto.getDisable());
        user.setLocked(userCreateDto.getLocked());

        User userCreated = userRepository.save(user);
        assignRolesToUser(userCreated.getId(), List.of("guest")); // Asignar rol por defecto
        UserDto userResponse = UserMapper.toUserDto(userCreated);
        return userResponse;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id " + id + " no encontrado"));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuario con email " + email + " no encontrado"));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Usuario con username " + username + " no encontrado"));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UserCreateDto userCreateDto, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id " + id + " no encontrado"));
        existingUser.setEmail(userCreateDto.getEmail());
        existingUser.setUsername(userCreateDto.getUsername());
        
        if (userCreateDto.getPassword() != null && !userCreateDto.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        }

        existingUser.setRoles(userCreateDto.getRoles());
        existingUser.setPhoneNumber(userCreateDto.getPhoneNumber());
        return UserMapper.toUserDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                    .map(user -> UserMapper.toUserDto(user))
                    .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByRole(String roleName) {
        List<User> users = userRepository.findByRolesName(roleName);
        return users.stream()
                    .map(user -> UserMapper.toUserDto(user))
                    .collect(Collectors.toList());
    }

    @Override
    public UserDto assignRolesToUser(Long userId, List<String> roles) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Usuario con id " + userId + " no encontrado"));
        List<Role> rolesList = roleRepository.findAllByNameIn(
                    roles.stream()
                    .map( rol -> rol.toLowerCase() )
                    .collect(Collectors.toList())
        );
        user.setRoles(rolesList);
        return UserMapper.toUserDto(userRepository.save(user)) ;
    }

    
}
