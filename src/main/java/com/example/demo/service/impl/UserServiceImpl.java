package com.example.demo.service.impl;

import com.example.demo.converters.UserConvertor;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConvertor userConvertor;


    public UserServiceImpl(UserRepository userRepository, UserConvertor userConvertor) {
        this.userRepository = userRepository;
        this.userConvertor = userConvertor;
    }


    @Override
    public UserDto save(UserDto userDto) {

        User user = userRepository.findUserByNameAndSurnameAndEmail(userDto.getName(),userDto.getSurname(),userDto.getEmail());
        if(user == null)
            return userConvertor.fromEntityToDto(userRepository.save(userConvertor.fromDtoToEntity(userDto)));

        return userConvertor.fromEntityToDto(user);
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return userRepository.findById(userId);
    }


}
