package com.apps.librarymanagementapp.service;

import com.apps.librarymanagementapp.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User save(User user);
}
