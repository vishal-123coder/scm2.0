package com.scm.services;

import java.util.List;
import com.scm.entities.User;

public interface UserService {
    User saveUser(User user);
    User getUserById(String id);
    User updateUser(User user);
    void deleteUserById(String id);
    List<User> getAllUsers();
    User getUserByEmail(String email);
}