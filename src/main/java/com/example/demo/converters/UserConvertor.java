package com.example.demo.converters;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public UserDto fromRequestToDto(UserRequest userRequest){
        UserDto userDto = new UserDto();
        userDto.setName(userRequest.getName());
        userDto.setSurname(userRequest.getSurname());
        userDto.setEmail(userRequest.getEmail());
        return userDto;
    }

    public UserResponse fromDtoToResponse(UserDto userDto){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDto.getId());
        userResponse.setName(userDto.getName());
        userResponse.setSurname(userDto.getSurname());
        userResponse.setEmail(userDto.getEmail());
        return userResponse;
    }

    public UserDto fromEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    public User fromDtoToEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        return user;
    }


}
