package com.matias.projects.profiles.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.matias.projects.profiles.exception.UserNotFoundException;
import com.matias.projects.profiles.interfaces.UserService;
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
    public User saveUser(User user) {
        user.setPassword( passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id " + id + " no encontrado"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("Usuario con email " + email + " no encontrado"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("Usuario con username " + username + " no encontrado"));
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("Usuario con id " + user.getId() + " no encontrado"));
        existingUser.setId(0L);
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(String roleName) {
        return userRepository.findByRolesName(roleName);
    }

    @Override
    public User assignRolesToUser(Long userId, List<String> roles) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Usuario con id " + userId + " no encontrado"));
        List<Role> rolesList = roleRepository.findAllByNameIn(roles);
        for (Role role : rolesList) {
            System.out.println(role.getName());
        }
        user.setRoles(rolesList);
        return userRepository.save(user);
    }
    
}
