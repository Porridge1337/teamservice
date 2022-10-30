package ru.soap.teamservice.dao;

import ru.soap.teamservice.model.Group;

import java.util.List;

public interface DaoGroup {

    List<Group> findAllGroups();

    boolean saveGroup(Group group);

    boolean updateGroup(Group group);

    boolean deleteGroupById(int id);

}
