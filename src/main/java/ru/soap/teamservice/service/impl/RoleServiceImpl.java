package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoRole;
import ru.soap.teamservice.dao.impl.DaoRoleImpl;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.service.RoleService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.RoleService")
public class RoleServiceImpl implements RoleService {

    private final DaoRole daoRole = new DaoRoleImpl();

    @Override
    public List<Role> findAllUserRoles() {
        return daoRole.findUserRoles();
    }

    @Override
    public boolean saveNewRole(Role role) {
        return daoRole.saveNewRole(role);
    }
}
