package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoUser;
import ru.soap.teamservice.dao.impl.DaoUserImpl;
import ru.soap.teamservice.mapper.UserMapper;
import ru.soap.teamservice.mapper.impl.UserMapperImpl;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.model.dto.UserDto;
import ru.soap.teamservice.service.UserService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.UserService")
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser = new DaoUserImpl();
    private final UserMapper userMapper = new UserMapperImpl();

    @Override
    public List<UserDto> findAllUsers() {
        return userMapper.toUserDtos(daoUser.findAll());
    }

    @Override
    public List<UserDto> findUsersByRole(String roleName) {
        return userMapper.toUserDtos(daoUser.findUsersByRole(roleName));
    }

    @Override
    public List<UserDto> findUsersByGroup(String groupName) {
        return userMapper.toUserDtos(daoUser.findUsersByGroup(groupName));
    }

    @Override
    public UserDto findUserById(int id) {
        return userMapper.toUserDto(daoUser.findUserById(id).orElse(null));
    }

    @Override
    public UserDto findUserByLogin(String login) {
        return userMapper.toUserDto(daoUser.findUserByLogin(login).orElse(null));
    }

    @Override
    public UserDto findUserByTelegramId(String login) {
        return userMapper.toUserDto(daoUser.findUserByTelegramId(login).orElse(null));
    }

    @Override
    public boolean save(UserDto user) {
        User userEntity = userMapper.toEntityUser(user);
        return daoUser.save(userEntity);
    }

    @Override
    public boolean update(UserDto user) {
        User userEntity = userMapper.toEntityUser(user);
        return daoUser.update(userEntity);
    }

    @Override
    public boolean deleteUserById(int id) {
        return daoUser.deleteUserById(id);
    }
}
