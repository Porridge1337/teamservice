package ru.soap.teamservice.mapper;

import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.dto.RoleDto;

import java.util.List;

public interface RoleMapper {

    RoleDto toRoleDto(Role entity);

    Role toEntityRole(RoleDto roleDto);

    List<RoleDto> toRoleDtos(List<Role> entities);

    List<Role> toEntityRoles(List<RoleDto> dtos);

}
