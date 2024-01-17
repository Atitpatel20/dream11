package com.dream11.dream11.controller;

import com.dream11.dream11.payload.UserDto;
import com.dream11.dream11.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id){
        UserDto dto = userService.getUserById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping
    public List<UserDto> getAllUser(){
        List<UserDto> dtos= userService.getAllUser();
        return dtos;
    }
}
