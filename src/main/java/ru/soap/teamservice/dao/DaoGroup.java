package ru.soap.teamservice.dao;

import ru.soap.teamservice.model.Group;

import javax.jws.WebParam;
import java.util.List;

public interface DaoGroup {

    List<Group> findAllGroups();

    boolean saveGroup(@WebParam(name = "saved-group") Group group);

    boolean updateGroup(@WebParam(name = "updated-group") Group group);

    boolean deleteGroupById(int id);

}
