package org.example.projectbibiliotheque.service;

import org.example.projectbibiliotheque.dto.UserDto;
import org.example.projectbibiliotheque.entities.Role;
import org.example.projectbibiliotheque.entities.User;
import org.example.projectbibiliotheque.repositories.RoleRepository;
import org.example.projectbibiliotheque.repositories.UserRepository;
import org.example.projectbibiliotheque.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;





    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(userDto.getName(),userDto.getPrenom(),userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
            return userRepository.findAll();
        }

}