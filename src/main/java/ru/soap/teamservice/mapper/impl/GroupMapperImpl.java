package ru.soap.teamservice.mapper.impl;

import org.modelmapper.ModelMapper;
import ru.soap.teamservice.mapper.GroupMapper;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.dto.GroupDto;

import java.util.List;
import java.util.stream.Collectors;

public class GroupMapperImpl implements GroupMapper {

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public GroupDto toGroupDto(Group entity) {
        GroupDto groupDto = modelMapper.map(entity, GroupDto.class);
        return groupDto;
    }

    @Override
    public Group toEntityGroup(GroupDto groupDto) {
        Group group = modelMapper.map(groupDto, Group.class);
        return group;
    }

    @Override
    public List<GroupDto> toGroupDtos(List<Group> entities) {
        return entities.stream().map(group -> modelMapper.map(group, GroupDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<Group> toEntityGroup(List<GroupDto> dtos) {
        return dtos.stream().map(group -> modelMapper.map(group, Group.class)).collect(Collectors.toList());
    }
}
