package com.matias.projects.profiles.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.projects.profiles.dto.UserCreateDto;
import com.matias.projects.profiles.dto.UserDto;
import com.matias.projects.profiles.interfaces.UserService;
import com.matias.projects.profiles.models.User;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping({"","/"})
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping
    public UserDto saveUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.saveUser(userCreateDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PatchMapping("{id}/roles")
    public UserDto assignRolesUser(@PathVariable Long id, @RequestBody List<String> roles) {
        return userService.assignRolesToUser(id, roles);
    }
}
