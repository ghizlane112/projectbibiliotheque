package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.dto.UserDto;
import org.example.projectbibiliotheque.entities.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);


     List<User> findAllUsers();
}