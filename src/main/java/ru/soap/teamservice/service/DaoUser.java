package ru.soap.teamservice.service;

import ru.soap.teamservice.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@WebService
public interface DaoUser {

    @WebMethod(operationName = "findAllUsers")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllUsers", localName = "findAllUsers")
    List<User> findAll();

    @WebMethod(operationName = "findUsersByRoleId")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByRoleId", localName = "findUsersByRoleId")
    List<User> findUsersByRole(@WebParam(name = "roleName") String roleName);

    @WebMethod(operationName = "findUsersByGroupId")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByGroupId", localName = "findUsersByGroupId")
    List<User> findUsersByGroup(@WebParam(name = "groupName") String groupName);

    @WebMethod(operationName = "findUserById")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserById", localName = "findUserById")
    User findUserById(@WebParam(name = "user-id") int id);

    @WebMethod(operationName = "findUserByLogin")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByLogin", localName = "findUserByLogin")
    User findUserByLogin(@WebParam(name = "user-telegramLogin") String login);

    @WebMethod(operationName = "saveUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveUser", localName = "saveUser")
    boolean save(@WebParam(name = "saved-user") User user);

    @WebMethod(operationName = "updateUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateUser", localName = "updateUser")
    boolean update(@WebParam(name = "updated-user") User user);

    @WebMethod(operationName = "deleteUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.deleteUser", localName = "deleteUser")
    boolean deleteUserById(@WebParam(name = "id-of-the-user-to-be-deleted") int id);

}
