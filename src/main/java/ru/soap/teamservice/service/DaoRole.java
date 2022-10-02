package ru.soap.teamservice.service;

import ru.soap.teamservice.model.Role;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@WebService
public interface DaoRole {

    @WebMethod(operationName = "findUserRoleById")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserRoleById", localName = "findUserRoleById")
    List<Role> findUserRoles();

    @WebMethod(operationName = "saveNewRole")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveNewRole", localName = "saveNewRole")
    boolean saveNewRole(Role role);
}
