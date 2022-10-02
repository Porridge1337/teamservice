package ru.soap.teamservice;

import ru.soap.teamservice.model.Group;
import ru.soap.teamservice.model.Role;
import ru.soap.teamservice.model.User;
import ru.soap.teamservice.service.DaoRole;
import ru.soap.teamservice.service.DaoUser;
import ru.soap.teamservice.service.impl.DaoRoleImpl;
import ru.soap.teamservice.service.impl.DaoUserImpl;

import javax.xml.ws.Endpoint;
import java.util.List;


public class WebServiceServer {

    public static void main(String[] args) {
       /* String bindingURI1 = "http://localhost:9898/team1";
        String bindingURI2 = "http://localhost:9898/team2";

        Endpoint.publish(bindingURI1, daoUser);
        Endpoint.publish(bindingURI2, daoRole);
        System.out.println("Server started at: " + bindingURI1);
        System.out.println("Server started at: " + bindingURI2);*/
        DaoUser daoUser = new DaoUserImpl();
        DaoRole daoRole = new DaoRoleImpl();



    }

}
