package com.dream11.dream11.service.impl;

import com.dream11.dream11.entity.User;
import com.dream11.dream11.exception.ResourceNotFoundException;
import com.dream11.dream11.payload.UserDto;
import com.dream11.dream11.repository.UserRepository;
import com.dream11.dream11.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User users= new User();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setMobile(userDto.getMobile());
        User saveUsers = userRepository.save(users);
        UserDto dto= new UserDto();
        dto.setName(saveUsers.getName());
        dto.setEmail(saveUsers.getEmail());
        dto.setMobile(saveUsers.getMobile());
        return dto;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found with id: "+id)
        );
        UserDto dto= new UserDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        return dto;
    }
}
