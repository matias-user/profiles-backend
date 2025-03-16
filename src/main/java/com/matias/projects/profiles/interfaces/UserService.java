package com.matias.projects.profiles.interfaces;

import java.util.List;

import com.matias.projects.profiles.models.User;

public interface UserService {
    public User saveUser(User user);
    public User getUserById(Long id);
    public User getUserByEmail(String email);
    public User getUserByUsername(String username);
    public User updateUser(User user);
    public void deleteUser(Long id);
    public List<User> getAllUsers();
    public List<User> getUsersByRole(String roleName);
}
