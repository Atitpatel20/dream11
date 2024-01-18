package com.dream11.dream11.service;

import com.dream11.dream11.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(long id);

    List<UserDto> getAllUser(int pageNo, int pageSize);
}
