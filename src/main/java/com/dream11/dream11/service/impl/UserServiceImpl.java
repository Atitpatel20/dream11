package com.dream11.dream11.service.impl;

import com.dream11.dream11.entity.User;
import com.dream11.dream11.exception.ResourceNotFoundException;
import com.dream11.dream11.payload.UserDto;
import com.dream11.dream11.repository.UserRepository;
import com.dream11.dream11.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        UserDto dto = mapToDto(saveUsers);
        return dto;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Record not found with id: "+id)
        );
        UserDto userDto = mapToDto(user);
        return userDto;
    }
    @Override
    public List<UserDto> getAllUser(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> pageUsers = userRepository.findAll(pageable);
        List<User> users = pageUsers.getContent();
        List<UserDto> dtos = users.stream().map(u -> mapToDto(u)).collect(Collectors.toList());
        return dtos;
    }

    UserDto mapToDto(User user){
        UserDto userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMobile(user.getMobile());
        return userDto;
    }
    User mapToEntity(UserDto userDto){
        User user= new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobile(userDto.getMobile());
        return user;
    }
}
