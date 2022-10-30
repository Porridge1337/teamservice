package ru.soap.teamservice.mapper.impl;

import org.modelmapper.ModelMapper;
import ru.soap.teamservice.mapper.RoleMapper;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.dto.RoleDto;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapperImpl implements RoleMapper {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public RoleDto toRoleDto(Role entity) {
        RoleDto roleDto = modelMapper.map(entity, RoleDto.class);
        return roleDto;
    }

    @Override
    public Role toEntityRole(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        return role;
    }

    @Override
    public List<RoleDto> toRoleDtos(List<Role> entities) {
        return entities.stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<Role> toEntityRoles(List<RoleDto> dtos) {
        return dtos.stream().map(roleDto -> modelMapper.map(roleDto, Role.class)).collect(Collectors.toList());
    }
}
