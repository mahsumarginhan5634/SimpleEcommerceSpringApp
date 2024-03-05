package com.example.demo.controller;

import com.example.demo.converters.UserConvertor;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserConvertor userConvertor;

    public UserController(UserServiceImpl userService,UserConvertor userConvertor){
        this.userService = userService;
        this.userConvertor = userConvertor;
    }

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest){
        return userConvertor.fromDtoToResponse(userService.save(userConvertor.fromRequestToDto(userRequest)));
    }


}
