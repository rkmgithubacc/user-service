package com.rkmgithubacc.mba.userms.service;

import com.rkmgithubacc.mba.userms.dao.UserDAO;
import com.rkmgithubacc.mba.userms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User getUserBasedOnId(int id) {
        return userDAO.findById(id).isPresent() ? userDAO.findById(id).get() : null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User updateUser(User user) {
        User storedUser = getUserBasedOnId(user.getUserID());
        storedUser.setUserID(user.getUserID());
        storedUser.setFirstName(user.getFirstName());
        storedUser.setLastName(user.getLastName());
        storedUser.setUserName(user.getUserName());
        storedUser.setPassword(user.getPassword());
        storedUser.setDateOfBirth(user.getDateOfBirth());
        storedUser.setPhoneNumbersSet(user.getPhoneNumbersSet());
        return userDAO.save(storedUser);
    }

    @Override
    public Boolean deleteUser(User user) {
        User storedUser = getUserBasedOnId(user.getUserID());
        if (storedUser == null) {
            return false;
        }

        userDAO.delete(storedUser);
        return true;
    }
}
