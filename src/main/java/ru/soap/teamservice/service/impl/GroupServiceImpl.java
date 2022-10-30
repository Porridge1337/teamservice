package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoGroup;
import ru.soap.teamservice.dao.impl.DaoGroupImpl;
import ru.soap.teamservice.mapper.GroupMapper;
import ru.soap.teamservice.mapper.impl.GroupMapperImpl;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.dto.GroupDto;
import ru.soap.teamservice.service.GroupService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.GroupService")
public class GroupServiceImpl implements GroupService {

    private final DaoGroup daoGroup = new DaoGroupImpl();
    private GroupMapper groupMapper = new GroupMapperImpl();

    @Override
    public List<GroupDto> findAllGroups() {
        return groupMapper.toGroupDtos(daoGroup.findAllGroups());
    }

    @Override
    public boolean saveGroup(GroupDto group) {
        Group groupEntity = groupMapper.toEntityGroup(group);
        return daoGroup.saveGroup(groupEntity);
    }

    @Override
    public boolean updateGroup(GroupDto group) {
        Group groupEntity = groupMapper.toEntityGroup(group);
        return daoGroup.updateGroup(groupEntity);
    }

    @Override
    public boolean deleteGroupById(int id) {
        return daoGroup.deleteGroupById(id);
    }
}
