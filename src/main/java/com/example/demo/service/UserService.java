package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.Optional;

public interface UserService {
    UserDto save(UserDto userDto);

    Optional<User> findById(Integer userId);
}
