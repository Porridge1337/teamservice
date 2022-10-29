package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoUser;
import ru.soap.teamservice.dao.impl.DaoUserImpl;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.service.UserService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.UserService")
public class UserServiceImpl implements UserService {

    private final DaoUser daoUser = new DaoUserImpl();

    @Override
    public List<User> findAllUsers() {
        return daoUser.findAll();
    }

    @Override
    public List<User> findUsersByRole(String roleName) {
        return daoUser.findUsersByRole(roleName);
    }

    @Override
    public List<User> findUsersByGroup(String groupName) {
        return daoUser.findUsersByGroup(groupName);
    }

    @Override
    public User findUserById(int id) {
        return daoUser.findUserById(id).orElse(null);
    }

    @Override
    public User findUserByLogin(String login) {
        return daoUser.findUserByLogin(login).orElse(null);
    }

    @Override
    public User findUserByTelegramId(String login) {
        return daoUser.findUserByTelegramId(login).orElse(null);
    }

    @Override
    public boolean save(User user) {
        return daoUser.save(user);
    }

    @Override
    public boolean update(User user) {
        return daoUser.update(user);
    }

    @Override
    public boolean deleteUserById(int id) {
        return daoUser.deleteUserById(id);
    }
}
