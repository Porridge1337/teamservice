package ru.soap.teamservice.mapper.impl;

import org.modelmapper.ModelMapper;
import ru.soap.teamservice.mapper.UserMapper;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.model.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapperImpl implements UserMapper {

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public UserDto toUserDto(User userEntity) {
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    @Override
    public User toEntityUser(UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        return userEntity;
    }

    @Override
    public List<UserDto> toUserDtos(List<User> userEntities) {
        return userEntities.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<User> toEntityUsers(List<UserDto> userDtos) {
        return userDtos.stream().map(userDto -> modelMapper.map(userDtos, User.class)).collect(Collectors.toList());
    }
}
