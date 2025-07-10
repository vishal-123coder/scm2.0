package com.scm.services.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.scm.entities.User;
import com.scm.helpers.AppConstants;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    // private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // set the user role

        user.setRoleList(List.of(AppConstants.ROLE_USER));

        return userRepo.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        if (userRepo.existsById(user.getUserId())) {
            if (user.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUserById(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}