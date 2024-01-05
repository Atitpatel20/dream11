package com.dream11.dream11.controller;

import com.dream11.dream11.payload.UserDto;
import com.dream11.dream11.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
        UserDto users = userService.createUser(userDto);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }
}
