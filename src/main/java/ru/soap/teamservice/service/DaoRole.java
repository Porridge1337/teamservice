package ru.soap.teamservice.service;

import ru.soap.teamservice.model.Role;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@WebService
public interface DaoRole {

    @WebMethod(operationName = "findUserRoles")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserRoles", localName = "findUserRoles")
    List<Role> findUserRoles();

    @WebMethod(operationName = "saveNewRole")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveNewRole", localName = "saveNewRole")
    boolean saveNewRole(@WebParam(name = "new-save-role") Role role);
}
