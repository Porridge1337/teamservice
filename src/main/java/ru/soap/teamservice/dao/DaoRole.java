package ru.soap.teamservice.dao;

import ru.soap.teamservice.model.Role;

import java.util.List;


public interface DaoRole {

    List<Role> findUserRoles();

    boolean saveNewRole(Role role);
}
