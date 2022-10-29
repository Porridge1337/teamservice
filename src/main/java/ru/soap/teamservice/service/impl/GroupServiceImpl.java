package ru.soap.teamservice.service.impl;

import ru.soap.teamservice.dao.DaoGroup;
import ru.soap.teamservice.dao.impl.DaoGroupImpl;
import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.service.GroupService;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.soap.teamservice.service.GroupService")
public class GroupServiceImpl implements GroupService {

    private final DaoGroup daoGroup = new DaoGroupImpl();

    @Override
    public List<Group> findAllGroups() {
        return daoGroup.findAllGroups();
    }

    @Override
    public boolean saveGroup(Group group) {
        return daoGroup.saveGroup(group);
    }

    @Override
    public boolean updateGroup(Group group) {
        return daoGroup.updateGroup(group);
    }

    @Override
    public boolean deleteGroupById(int id) {
        return daoGroup.deleteGroupById(id);
    }
}
