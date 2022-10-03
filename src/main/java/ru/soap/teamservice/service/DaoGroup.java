package ru.soap.teamservice.service;

import ru.soap.teamservice.model.Group;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@WebService
public interface DaoGroup {

    @WebMethod(operationName = "findAllGroups")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllGroups", localName = "findAllGroups")
    List<Group> findAllGroups();

    @WebMethod(operationName = "saveGroup")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveGroup", localName = "saveGroup")
    boolean saveGroup(@WebParam(name = "saved-group") Group group);

    @WebMethod(operationName = "updateGroup")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateGroup", localName = "updateGroup")
    boolean updateGroup(@WebParam(name = "updated-group") Group group);

    @WebMethod(operationName = "deleteGroupById")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.DeleteGroupById", localName = "deleteGroupById")
    boolean deleteGroupById(@WebParam(name = "group id to be deleted") int id);

}
