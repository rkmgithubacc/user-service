package com.rkmgithubacc.mba.userms.utils;

import com.rkmgithubacc.mba.userms.dto.UserDTO;
import com.rkmgithubacc.mba.userms.model.User;

public class POJOConverter {
    public static UserDTO covertUserEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhoneNumbersSet(user.getPhoneNumbersSet());
        userDTO.setUserID(user.getUserID());
        userDTO.setUserName(user.getUserName());

        return userDTO;
    }

    public static User covertUserDTOToEntity(UserDTO userDTO) {
        User user = new User();
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumbersSet(userDTO.getPhoneNumbersSet());
        user.setUserID(userDTO.getUserID());
        user.setUserName(userDTO.getUserName());

        return user;
    }
}
