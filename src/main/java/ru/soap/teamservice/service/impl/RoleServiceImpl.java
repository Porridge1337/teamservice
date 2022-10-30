package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoRole;
import ru.soap.teamservice.dao.impl.DaoRoleImpl;
import ru.soap.teamservice.mapper.RoleMapper;
import ru.soap.teamservice.mapper.impl.RoleMapperImpl;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.dto.RoleDto;
import ru.soap.teamservice.service.RoleService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.RoleService")
public class RoleServiceImpl implements RoleService {

    private final DaoRole daoRole = new DaoRoleImpl();
    private final RoleMapper roleMapper = new RoleMapperImpl();

    @Override
    public List<RoleDto> findAllUserRoles() {
        return roleMapper.toRoleDtos(daoRole.findUserRoles());
    }

    @Override
    public boolean saveNewRole(RoleDto role) {
        Role savedRole = roleMapper.toEntityRole(role);
        return daoRole.saveNewRole(savedRole);
    }
}
