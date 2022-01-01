package com.rkmgithubacc.mba.userms.controller;

import com.rkmgithubacc.mba.userms.dto.UserDTO;
import com.rkmgithubacc.mba.userms.model.User;
import com.rkmgithubacc.mba.userms.service.UserService;
import com.rkmgithubacc.mba.userms.utils.POJOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user_service/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Register/ create user record
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User newUser = POJOConverter.covertUserDTOToEntity(userDTO);
        User savedUser = userService.createUser(newUser);
        UserDTO savedUserDTO = POJOConverter.covertUserEntityToDTO(savedUser);

        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

    //Get all users
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> usersList = userService.getAllUsers();
        List<UserDTO> usersDTOList = new ArrayList<>();
        for (User user : usersList) {
            usersDTOList.add(POJOConverter.covertUserEntityToDTO(user));
        }

        return new ResponseEntity<>(usersDTOList, HttpStatus.OK);
    }

    //Get a single user based on ID
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserForId(@PathVariable(name = "id") int id) {
        User retrievedUser = userService.getUserBasedOnId(id);

        if (retrievedUser != null) {
            UserDTO retrievedUserDTO = POJOConverter.covertUserEntityToDTO(retrievedUser);
            return new ResponseEntity<>(retrievedUserDTO, HttpStatus.OK);
        } else {
            return null;
        }
    }

    //Update user details
    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUserForId(@RequestBody UserDTO userDTO) {
        User userToUpdate = POJOConverter.covertUserDTOToEntity(userDTO);
        User updatedUser = userService.updateUser(userToUpdate);
        UserDTO updatedUserDTO = POJOConverter.covertUserEntityToDTO(updatedUser);

        return new ResponseEntity<>(updatedUserDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "id") int id) {
        User userToBeDeleted = userService.getUserBasedOnId(id);
        Boolean deleteStatus = userService.deleteUser(userToBeDeleted);

        return new ResponseEntity<>(deleteStatus, HttpStatus.OK);
    }
}
