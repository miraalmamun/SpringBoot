package com.jpa.practice.service;

import com.jpa.practice.model.Users;
import com.jpa.practice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(String name, String addressJson) {
        Users user = new Users();
        user.setName(name);
        user.setAddress(addressJson);
        return userRepository.save(user);
    }

    public List<Users> getUsersByCity(String city) {
        return userRepository.findByCity(city);
    }
}
