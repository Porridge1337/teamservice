package ru.soap.teamservice.service;

import ru.soap.teamservice.model.Role;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService
public interface RoleService {

    @WebMethod(operationName = "findUserRoles")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserRoles", localName = "findUserRoles")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserRolesResponse", localName = "FindUserRolesResponse")
    List<Role> findAllUserRoles();

    @WebMethod(operationName = "saveNewRole")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveNewRole", localName = "saveNewRole")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.saveNewRoleResponse", localName = "saveNewRoleResponse")
    boolean saveNewRole(@WebParam(name = "new-save-role") Role role);

}
