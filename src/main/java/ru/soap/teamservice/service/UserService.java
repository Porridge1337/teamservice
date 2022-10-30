package ru.soap.teamservice.service;

import ru.soap.teamservice.model.User;
import ru.soap.teamservice.model.dto.UserDto;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;
import java.util.Optional;

@WebService
public interface UserService {

    @WebMethod(operationName = "findAllUsers")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllUsers", localName = "findAllUsers")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindAllUsersResponse", localName = "findAllUsersResponse")
    List<UserDto> findAllUsers();

    @WebMethod(operationName = "findUsersByRolename")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByRolename", localName = "findUsersByRolename")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByRolenameResponse",
            localName = "findUsersByRolenameResponse")
    List<UserDto> findUsersByRole(@WebParam(name = "roleName") String roleName);

    @WebMethod(operationName = "findUsersByGroupname")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByGroupname", localName = "findUsersByGroupname")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUsersByGroupnameResponse",
            localName = "FindUsersByGroupnameResponse")
    List<UserDto> findUsersByGroup(@WebParam(name = "groupName") String groupName);

    @WebMethod(operationName = "findUserById")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserById", localName = "findUserById")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByIdResponse", localName = "FindUserByIdResponse")
    UserDto findUserById(@WebParam(name = "user-id") int id);

    @WebMethod(operationName = "findUserByLogin")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByLogin", localName = "findUserByLogin")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByLoginResponse", localName = "FindUserByLoginResponse")
    UserDto findUserByLogin(@WebParam(name = "user-telegramLogin") String login);

    @WebMethod(operationName = "findUserByTelegramId")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByTelegramId", localName = "FindUserByTelegramId")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.FindUserByTelegramIdResponse",
            localName = "FindUserByTelegramIdResponse")
    UserDto findUserByTelegramId(@WebParam(name = "user-telegramId") String login);

    @WebMethod(operationName = "saveUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.SaveUser", localName = "saveUser")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.SaveUserResponse", localName = "SaveUserResponse")
    boolean save(@WebParam(name = "saved-user") UserDto user);

    @WebMethod(operationName = "updateUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateUser", localName = "updateUser")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.UpdateUserResponse", localName = "UpdateUserResponse")
    boolean update(@WebParam(name = "updated-user") UserDto user);

    @WebMethod(operationName = "deleteUser")
    @RequestWrapper(className = "ru.soap.teamservice.service.jaxws.deleteUser", localName = "deleteUser")
    @ResponseWrapper(className = "ru.soap.teamservice.service.jaxws.deleteUserResponse", localName = "deleteUserResponse")
    boolean deleteUserById(@WebParam(name = "id-of-the-user-to-be-deleted") int id);
}
