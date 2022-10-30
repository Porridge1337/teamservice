package ru.soap.teamservice.mapper;

import ru.soap.teamservice.model.User;
import ru.soap.teamservice.model.dto.UserDto;

import java.util.List;

public interface UserMapper {

    UserDto toUserDto(User userEntity);

    User toEntityUser(UserDto userDto);

    List<UserDto> toUserDtos(List<User> userEntities);

    List<User> toEntityUsers(List<UserDto> userDtos);


}
