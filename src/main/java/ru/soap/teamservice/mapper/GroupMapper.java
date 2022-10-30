package ru.soap.teamservice.mapper;

import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.dto.GroupDto;
import ru.soap.teamservice.model.dto.RoleDto;

import java.util.List;

public interface GroupMapper {

    GroupDto toGroupDto(Group entity);

    Group toEntityGroup(GroupDto groupDto);

    List<GroupDto> toGroupDtos(List<Group> entities);

    List<Group> toEntityGroup(List<GroupDto> dtos);

}
