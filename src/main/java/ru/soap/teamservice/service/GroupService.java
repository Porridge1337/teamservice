package ru.soap.teamservice.service;

import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.dto.GroupDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public interface GroupService {

    @WebMethod(operationName = "findAllGroups")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllGroups", localName = "findAllGroups")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllGroupsResponse", localName = "FindAllGroupsResponse")
    List<GroupDto> findAllGroups();

    @WebMethod(operationName = "saveGroup")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveGroup", localName = "saveGroup")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.SaveGroupResponse", localName = "SaveGroupResponse")
    boolean saveGroup(@WebParam(name = "saved-group") GroupDto group);

    @WebMethod(operationName = "updateGroup")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateGroup", localName = "updateGroup")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateGroupResponse", localName = "UpdateGroupResponse")
    boolean updateGroup(@WebParam(name = "updated-group") GroupDto group);

    @WebMethod(operationName = "deleteGroupById")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.DeleteGroupById", localName = "deleteGroupById")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.DeleteGroupByIdResponse", localName = "DeleteGroupByIdResponse")
    boolean deleteGroupById(@WebParam(name = "group-id-to-be-deleted") int id);
}
