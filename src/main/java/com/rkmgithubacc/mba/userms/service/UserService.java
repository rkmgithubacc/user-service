package com.rkmgithubacc.mba.userms.service;

import com.rkmgithubacc.mba.userms.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserBasedOnId(int id);

    List<User> getAllUsers();

    User updateUser(User user);

    Boolean deleteUser(User user);
}
